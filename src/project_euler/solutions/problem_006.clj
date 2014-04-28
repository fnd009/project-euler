(ns project-euler.solutions.problem-006)

(defn square
  [n]
  (* n n))

(defn sum-squared
  "
The sum of the squares of the first ten natural numbers is,
1^2 + 2^2 + ... + 10^2 = 385

The square of the sum of the first ten natural numbers is,
(1 + 2 + ... + 10)^2 = 552 = 3025

Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
"
  [n]
  (- (square (reduce + (range 1 (inc n))))
     (reduce + (map square (range 1 (inc n))))))

(defn run
  []
  (println (sum-squared 10)))