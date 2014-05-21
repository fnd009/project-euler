(ns project-euler.core
  (:gen-class)  
  (:require [project-euler.solutions.problem-001 :as p001]
            [project-euler.solutions.problem-002 :as p002]
            [project-euler.solutions.problem-003 :as p003]
            [project-euler.solutions.problem-005 :as p005]
            [project-euler.solutions.problem-014 :as p014]
            [project-euler.solutions.problem-016 :as p016]
            [project-euler.solutions.problem-020 :as p020]
            [project-euler.solutions.problem-030 :as p030]))

(defmacro run
  [f]
  `(println f)
  `(f/run))

(defn -main
  "Check out https://projecteuler.net for the questions."
  [& args]
  (println "Project Euler started!")
  (p014/run))