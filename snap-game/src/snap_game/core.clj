(ns snap-game.core
  (:gen-class))

(def suits ["Spade" "Heart" "Diamond" "Club"])

(def two-to-ten (map str (rest (range 10))))

(def ranks-seq (concat ["Ace"] two-to-ten ["Jack" "Queen" "King"]))

(def ranks (into [] ranks-seq))

(defn create-card
  [suit rank]
  (str rank " of " suit))

(defn create-cards-for-suit
  [suit]
  (map (partial create-card suit) ranks))

(def create-deck
  (flatten (map create-cards-for-suit suits)))

(defn winner?
  [player-one player-two]
  (if (< (:think-time player-one) (:think-time player-two))
    (:name player-one)
    (:name player-two)))

