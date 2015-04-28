(ns project-euler.solutions.problem-002)

; Even fibonacci numbers.
; By considering the terms in the Fibbonaci sequence whose values do not exceed four million,
; find the sum of the even-valued terms.

(def fibo (lazy-cat [0 1] (map + fibo (rest fibo))))

(defn sum-of-even-fib
  []
  (reduce + (filter even? (filter #(< % 4000000) (take 40 fibo)))))

(defn fib
  ([]
   (fib 0 1))
  ([a b]
   (cons a (lazy-seq (fib b (+ b a))))))

(defn run
  []
  (println (sum-of-even-fib)))



