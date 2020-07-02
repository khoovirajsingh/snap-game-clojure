(ns snap-game.core
  (:gen-class))

(def suits ["Spade" "Heart" "Diamond" "Club"])

(def ranks-seq (concat ["Ace"] (map str (rest (range 10))) ["Jack" "Queen" "King"]))

(def ranks (into [] ranks-seq))

(defn create-card
  [suit rank]
  (str rank " of " suit))

(defn create-cards-for-suit
  [suit]
  (map (partial create-card suit) ranks))

(def create-deck
  (flatten (map create-cards-for-suit suits)))
