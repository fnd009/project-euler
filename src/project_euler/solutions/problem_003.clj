(ns project-euler.solutions.problem-003
  (:use [clojure.contrib.lazy-seqs]))

(def n 13195)

(defn p
  [n]
  (filter #(= 0 (mod n %)) (range 2 n)))


(defn prime
  "Largest prime factor.
   The prime factors of 13195 are 5, 7, 13, 29.
   What is the largest prime factor of the number 600851475143?"
  ([]
   (prime 2))
  ([n]
   (cons n (lazy-seq (filter #(zero? (rem n 1)))))))


(defn run
  []
  ;(primes 10)
 ; (println (take 10 (primes)))
  )