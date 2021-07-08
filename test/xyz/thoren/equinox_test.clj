(ns xyz.thoren.equinox-test
  (:require [clojure.test :refer [deftest is testing]]
            [xyz.thoren.equinox :as e]))

(deftest march
  (testing "the basic sanity of the march equinox calculations"
    (let [r #(e/march-equinox %)
          y #(is (= (:year (r %)) %))
          m #(is (= (:month (r %)) 3))
          d #(is (some (fn [day] (= (:day (r %)) day)) [19 20 21]))]
      (doseq [year (range 1900 2100)]
        (y year)
        (m year)
        (d year)))))

(deftest june
  (testing "the basic sanity of the march solstice calculations"
    (let [r #(e/june-solstice %)
          y #(is (= (:year (r %)) %))
          m #(is (= (:month (r %)) 6))
          d #(is (some (fn [day] (= (:day (r %)) day)) [20 21 22]))]
      (doseq [year (range 1900 2100)]
        (y year)
        (m year)
        (d year)))))

(deftest september
  (testing "the basic sanity of the september equinox calculations"
    (let [r #(e/september-equinox %)
          y #(is (= (:year (r %)) %))
          m #(is (= (:month (r %)) 9))
          d #(is (some (fn [day] (= (:day (r %)) day)) [21 22 23 24]))]
      (doseq [year (range 1900 2100)]
        (y year)
        (m year)
        (d year)))))

(deftest december
  (testing "the basic sanity of the december solstice calculations"
    (let [r #(e/december-solstice %)
          y #(is (= (:year (r %)) %))
          m #(is (= (:month (r %)) 12))
          d #(is (some (fn [day] (= (:day (r %)) day)) [20 21 22 23]))]
      (doseq [year (range 1900 2100)]
        (y year)
        (m year)
        (d year)))))
