(ns xyz.thoren.equinox
  (:require [xyz.thoren.julian :refer [jdn->time]]))

(defn march-equinox
  "Given a `year`, return a map with the Gregorian time of the March equinox.

  Example: (march-equinox 2021)
  => {:year 2021, :month 3, :day 20, :hour 9, :minute 35, :second 36}"
  [year]
  (let [m (/ (- (double year) 2000) 1000)
        m2 (* m m)
        m3 (* m m2)
        m4 (* m m3)
        jdn (- (+ 2451623.80984
                  (* 365242.37404 m)
                  (* 0.05169 m2))
              (* 0.00411 m3)
              (* 0.00057 m4))]
    (jdn->time jdn)))

(defn june-solstice
  "Given a `year`, return a map with the Gregorian time of the June solstice.

  Example: (june-solstice 2021)
  => {:year 2021, :month 6, :day 21, :hour 3, :minute 24, :second 13}"
  [year]
  (let [m (/ (- (double year) 2000) 1000)
        m2 (* m m)
        m3 (* m m2)
        m4 (* m m3)
        jdn (- (+ 2451716.56767
                 (* 365241.62603 m)
                 (* 0.00325 m2)
                 (* 0.00888 m3))
               (* 0.00030 m4))]
    (jdn->time jdn)))

(defn september-equinox
  "Given a `year`, return a map with the Gregorian time of the September
  equinox.

  Example: (september-equinox 2021)
  => {:year 2021, :month 9, :day 22, :hour 19, :minute 11, :second 14}"
  [year]
  (let [m (/ (- (double year) 2000) 1000)
        m2 (* m m)
        m3 (* m m2)
        m4 (* m m3)
        jdn (- (+ 2451810.21715
                 (* 365242.01767 m)
                 (* 0.00337 m3)
                 (* 0.00078 m4))
               (* 0.11575 m2))]
    (jdn->time jdn)))

(defn december-solstice
  "Given a `year`, return a map with the Gregorian time of the December
  solstice.

  Example: (december-solstice 2021)
  => {:year 2021, :month 12, :day 21, :hour 15, :minute 46, :second 8}"
  [year]
  (let [m (/ (- (double year) 2000) 1000)
        m2 (* m m)
        m3 (* m m2)
        m4 (* m m3)
        jdn (- (+ 2451900.05952
                 (* 365242.74049 m)
                 (* 0.00032 m4))
               (* 0.06223 m2)
               (* 0.00823 m3))]
    (jdn->time jdn)))
