(ns snap-game.core
  (:gen-class))
(require '[clojure.string :as string])


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

(defn winner-name
  [player-one player-two]
  (if (< (:think-time player-one) (:think-time player-two))
    (:name player-one)
    (:name player-two)))

(defn player-to-card
  [player card]
  (merge player card))

(defn assign-card-to-player
  [players deck]
  (map player-to-card players deck))

(defn winner?
  [cards]
  (let [card-one (first cards)
        card-two (second cards)]
    (= (:rank card-one) (:rank card-two))))

(defn format-player-turn
  [play]
  (str (:name play) " turns card " "'" (:rank play) (:suit play) "'"))

(defn simulate-game
  [deck players]
  (let [game (assign-card-to-player players deck)
        hands (partition 2 game)]
    (if (not (some winner? hands))
      (str (string/join "\n" (map format-player-turn game)) "\nGame over! It is a draw!!"))))

(format-player-turn {:name "John" :think-time 0 :rank "K" :suit "S"})

(str (string/join ", " ["spam" nil "eggs" "" "spam"]) "hi")

