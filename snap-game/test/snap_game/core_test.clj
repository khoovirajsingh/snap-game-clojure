(ns snap-game.core-test
  (:require [clojure.test :refer :all]
            [snap-game.core :refer :all]))

(def player-one {:name "Player One" :think-time 0})
(def player-two {:name "Player Two" :think-time 1000})
(def players [player-one player-two])
(def ace-of-spade {:rank "A" :suit "S"})
(def king-of-club {:rank "K" :suit "C"})
(def deck [ace-of-spade king-of-club])

(deftest create-a-deck-of-52-unique-cards
  (is (= 52 (count create-deck)))
  (is (= ace-of-spade (first create-deck)))
  (is (= king-of-club (last create-deck))))

(deftest player-with-quickest-reaction-wins
  (is (= "Player One" (winner? player-one player-two))))

(deftest snap-when-rank-matches
  (is (= true (snap? {:rank "2" :suit "S"} {:rank "2" :suit "C"}))))

(deftest player-one-wins
  (is (= "Player One wins!" (simulate-game deck players))))
