(ns project-euler.solutions.problem-016)

(defn power-of
  [n p]
  (reduce *' (repeat p n)))

(defn explode-to-digits
  [number]
  (map #(- (int %) (int \0)) (str number)))

(defn power-digit-sum
  "215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
   What is the sum of the digits of the number 21000?"
  [n p]
  (reduce +' (explode-to-digits (power-of n p))))

(defn run
  []
  (println (power-digit-sum 2 1000)))