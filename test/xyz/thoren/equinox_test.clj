(ns xyz.thoren.equinox-test
  (:require [clojure.test :refer [deftest is testing]]
            [xyz.thoren.equinox :as e]))

(deftest vernal
  (testing "the basic sanity of the vernal equinox calculations"
    (let [r #(e/vernal-equinox %)
          y #(is (= (:year (r %)) %))
          m #(is (= (:month (r %)) 3))
          d #(is (some (fn [day] (= (:day (r %)) day)) [19 20 21]))]
      (doseq [year (range 1900 2100)]
        (y year)
        (m year)
        (d year)))))

(deftest summer
  (testing "the basic sanity of the summer solstice calculations"
    (let [r #(e/summer-solstice %)
          y #(is (= (:year (r %)) %))
          m #(is (= (:month (r %)) 6))
          d #(is (some (fn [day] (= (:day (r %)) day)) [20 21 22]))]
      (doseq [year (range 1900 2100)]
        (y year)
        (m year)
        (d year)))))

(deftest autumnal
  (testing "the basic sanity of the autumnal equinox calculations"
    (let [r #(e/autumnal-equinox %)
          y #(is (= (:year (r %)) %))
          m #(is (= (:month (r %)) 9))
          d #(is (some (fn [day] (= (:day (r %)) day)) [21 22 23 24]))]
      (doseq [year (range 1900 2100)]
        (y year)
        (m year)
        (d year)))))

(deftest winter
  (testing "the basic sanity of the winter solstice calculations"
    (let [r #(e/winter-solstice %)
          y #(is (= (:year (r %)) %))
          m #(is (= (:month (r %)) 12))
          d #(is (some (fn [day] (= (:day (r %)) day)) [20 21 22 23]))]
      (doseq [year (range 1900 2100)]
        (y year)
        (m year)
        (d year)))))
