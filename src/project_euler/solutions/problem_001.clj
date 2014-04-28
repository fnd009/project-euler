(ns project-euler.solutions.problem-001)

; Multiples of 3 and 5.
; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
; The sum of these multiples is 23.
; Find the sum of all the multiples of 3 or 5 below 1000.

(defn sum-of-factor-3-5
  [limit]
  (reduce + (filter #(or (= (mod % 3) 0) (= (mod % 5) 0)) (range limit))))

(defn run
  []
  (println (sum-of-factor-3-5 1000)))