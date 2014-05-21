(ns project-euler.solutions.problem-014)

; The following iterative sequence is defined for the set of positive integers:
; n → n/2 (n is even)
; n → 3n + 1 (n is odd)

; Using the rule above and starting with 13, we generate the following sequence:
; 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

; It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

; Which starting number, under one million, produces the longest chain?

; NOTE: Once the chain starts the terms are allowed to go above one million.

(import '(java.util.concurrent Executors))

(def collatz-seq-count
  (memoize (fn [n]
             ())))

(def collatz-seq
  (memoize (fn [n]
             (if (= n 1)
              '(1)
              (lazy-seq (if (even? n)
                        (cons n (collatz-seq (/ n 2)))
                        (cons n (collatz-seq (inc (* 3 n))))))))))

(defn get-collatz-seq
  [n]
  (lazy-seq (cons (hash-map n (count (collatz-seq n))) (get-collatz-seq (inc (inc n))))))


(defn get-max [c]
  (apply max-key val (apply merge c)))

(defn get-max-collatz-seq
  [n l m]
  (if (<= n l)
    (let [c (count (collatz-seq n))]
      (if (> c (val (first m)))
        (recur (inc (inc n)) l (hash-map n c))
        (recur (inc (inc n)) l m)))
    m))

(def default-set '{1 1})

(defn concurrent-collatz-seq [n l]
  (let [refs  (map ref (repeat n default-set))
        pool  (Executors/newFixedThreadPool n)
        tasks (map (fn [n]
                      (fn []
                        (dosync
                          (ref-set (nth refs n) (get-max-collatz-seq (inc (* n l)) (* (inc n) l) default-set)))))
                   (range n))]
    (doseq [future (.invokeAll pool tasks)]
      (.get future))
    (.shutdown pool)
    (get-max (map deref refs))))
 
(concurrent-collatz-seq 10 1000)


(defn longest-collatz-seq
  []
  ; Using lazy sequence
  ;(apply max-key val (apply merge (take 100 (get-collatz-seq 1))))
  
  ; Using max comparison
  ;(max-collatz-seq 1 '{1 1})
  
  ; Using parallel processing / multi-threading
  (concurrent-collatz-seq 10)
  
  )

(defn run
  []
  (println (longest-collatz-seq))) ; Ans:837799



;(time (apply max-key val (apply merge (take 1000000 (get-collatz-seq 1)))))
;(time (apply max-key val (apply merge (take 50000 (get-collatz-seq 1)))))