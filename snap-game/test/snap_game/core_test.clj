(ns snap-game.core-test
  (:require [clojure.test :refer :all]
            [snap-game.core :refer :all]))

(def player-one {:name "John" :think-time 0})
(def player-two {:name "Bob" :think-time 1000})
(def players [player-one player-two])
(def ace-of-spade {:rank "A" :suit "S"})
(def king-of-club {:rank "K" :suit "C"})
(def king-of-spade {:rank "K" :suit "S"})
(def winning-deck [king-of-spade king-of-club])
(def draw-deck [king-of-spade ace-of-spade])
(def game [{:name "John" :think-time 0 :rank "K" :suit "S"} {:name "Bob" :think-time 1000 :rank "K" :suit "C"}])

(deftest create-a-deck-of-52-unique-cards
  (is (= 52 (count create-deck)))
  (is (= ace-of-spade (first create-deck)))
  (is (= king-of-club (last create-deck))))

(deftest player-with-quickest-reaction-wins
  (is (= "John" (winner-name player-one player-two))))

(deftest acceptance-tests
  (is (= "Bob turns card 'KS'\nJohn turns card 'KC'\nSNAP! John is the winner!!" (simulate-game winning-deck players)))
  (is (= "John turns card 'KS'\nBob turns card 'AS'\nGame over! It is a draw!!" (simulate-game draw-deck players))))

(deftest card-to-player
  (is (= {:name "John" :think-time 0 :rank "A" :suit "S"} (player-to-card player-one ace-of-spade))))

(deftest cards-to-players
  (is (= game (assign-card-to-player players winning-deck))))

(deftest there-is-a-winner
  (is (= true (winner? game))))






