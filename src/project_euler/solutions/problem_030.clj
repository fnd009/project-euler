(ns project-euler.solutions.problem-030)

; Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

; 1634 = 1^4 + 6^4 + 3^4 + 4^4
; 8208 = 8^4 + 2^4 + 0^4 + 8^4
; 9474 = 9^4 + 4^4 + 7^4 + 4^4
; As 1 = 1^4 is not a sum it is not included.

; The sum of these numbers is 1634 + 8208 + 9474 = 19316.

; Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.

(defn nth-powers
  [n p]
  (reduce *' (repeat p n)))

(defn explode-to-digits
  [number]
  (map #(- (int %) (int \0)) (str number)))

(defn sum-fifth-powers
  [n]
  (lazy-seq (when (<= n 999999)
              (if (= n (reduce + (map #(nth-powers % 5) (explode-to-digits n))))
                (do
                  (println n)
                  (cons n (sum-fifth-powers (inc n))))
                (sum-fifth-powers (inc n))))))

(defn digit-fifth-powers
  [n]
  (reduce +' (sum-fifth-powers n)))

(defn run
  []
  (println (digit-fifth-powers 10000)))