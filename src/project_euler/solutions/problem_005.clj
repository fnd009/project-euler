(ns project-euler.solutions.problem-005)

(def max-divisible 20)

(defn inc-20 [i]
  (if (zero? (mod (inc i) max-divisible))
    (inc i)
    (recur (inc i))))

(defn divisible?
  [n i]
  (if (zero? (rem n i)) true false))

(defn check-divisible
  [n i]
  (if (<= i max-divisible)
    (if (divisible? n i)
      (recur n (inc i))
      false)
    true))

(defn smallest-number
  "2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
   What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?"
  [n]
  (println n)
  (if (check-divisible n 3) n (recur (inc-20 n)))
  )

(defn run
  []
  (println (smallest-number 1)))

; The answer is 232792560