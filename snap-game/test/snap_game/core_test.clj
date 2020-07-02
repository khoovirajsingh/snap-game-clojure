(ns snap-game.core-test
  (:require [clojure.test :refer :all]
            [snap-game.core :refer :all]))

(deftest create-a-deck-of-52-unique-cards
  (is (= 52 (count create-deck)))
  (is (= "AS" (first create-deck)))
  (is (= "KC" (last create-deck))))
