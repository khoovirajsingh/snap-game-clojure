(ns snap-game.core-test
  (:require [clojure.test :refer :all]
            [snap-game.core :refer :all]))

(def player-one {:name "Player One" :think-time 0})
(def player-two {:name "Player Two" :think-time 1000})

(deftest create-a-deck-of-52-unique-cards
  (is (= 52 (count create-deck)))
  (is (= "Ace of Spade" (first create-deck)))
  (is (= "King of Club" (last create-deck))))

(deftest player-with-quickest-reaction-wins
  (is (= "Player One" (winner? player-one player-two))))
