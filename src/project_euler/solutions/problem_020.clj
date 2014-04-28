(ns project-euler.solutions.problem-020)

(defn fac
  [n]
  (reduce *' (range 1 (inc n))))

(defn explode-to-digits
  [number]
  (map #(- (int %) (int \0)) (str number)))

(defn factorial-digit-sum
  "n! means n × (n − 1) × ... × 3 × 2 × 1
   For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
   and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
   Find the sum of the digits in the number 100!"
  [n]
  (reduce +' (explode-to-digits (fac n))))

(defn run
  []
  (println (factorial-digit-sum 100)))