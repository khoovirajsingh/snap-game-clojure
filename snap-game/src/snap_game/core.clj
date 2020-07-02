(ns snap-game.core
  (:gen-class))

(def suits ["Spade" "Heart" "Diamond" "Club"])

(def ranks-seq (concat ["Ace"] (map str (rest (range 10))) ["Jack" "Queen" "King"]))

(def ranks (into [] ranks-seq))

(defn create-card
  [rank suit]
  (str rank " of " suit))

(def create-deck
  (range 52))
