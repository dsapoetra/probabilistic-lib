(ns probabilistic-lib.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn factorial [n]
  (reduce *' (range 2 (inc n))))

(defn permutation [n r]
  (/ (factorial n) (factorial (- n r))))

(defn permutation-2 [n r]
  (/ (factorial n) (reduce *' (map #(factorial %) r))))

(defn combination [n r]
  (/ (factorial n) (* (factorial r) (factorial (- n r)))))

(defn poker-card-problem [list-of-card-taken number-of-card-taken]
  "if you took 2 ace, 3 jack, and 2 ten then it'll be [[4 2] [4 3] [4 2]]"
  (/ (reduce *' (map #(combination (first %) (last %)) list-of-card-taken)) (combination 52 number-of-card-taken)))
