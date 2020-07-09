(ns snap-game.core
  (:gen-class))

(def suits ["S" "H" "D" "C"])

(def two-to-ten (map str (rest (range 10))))

(def ranks-seq (concat ["A"] two-to-ten ["J" "Q" "K"]))

(def ranks (into [] ranks-seq))

(defn create-card
  [suit rank]
  {:rank rank :suit suit})

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

(defn snap?
  [player-one-card player-two-card]
  (= (:rank player-one-card) (:rank player-two-card)))

(defn player-to-card
  [player card]
  (merge player card))

(defn assign-card-to-player
  [players deck]
  (map player-to-card players deck))

(defn simulate-game
  [deck players]
  "SNAP! John is the winner!!")


