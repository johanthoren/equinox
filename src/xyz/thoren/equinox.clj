(ns xyz.thoren.equinox)

(defn jdn->gregorian-time
  "Given a Julian Day Number `jdn`, return a map with the Gregorian time.
  Example: (jdn->gregorian-time 2459293.8997175973)
  => {:year 2021, :month 3, :day 20, :hour 9, :minute 35, :second 35}"
  [jdn]
  (let [julian (+ 0.5 jdn)
        z (int julian)
        f (- julian (int julian))
        a (if (< z 2299161)
            z
            (let [alpha (int (/ (- z 1867216.25) 36524.25))]
              (+ z 1 (- alpha (int (/ alpha 4))))))
        b (+ a 1524)
        c (int (/ (- b 122.1) 365.25))
        d (int (* 365.25 c))
        e (int (/ (- b d) 30.6001))
        month (if (< e 14)
                (dec e)
                (- e 13))
        year (if (> month 2)
               (- c 4716)
               (- c 4715))
        day-with-decimal (+ f (- b d (int (* 30.6001 e))))
        day (int day-with-decimal)
        fraction-of-day (- day-with-decimal day)
        hour-with-decimal (* 24 fraction-of-day)
        hour (int hour-with-decimal)
        fraction-of-hour (- hour-with-decimal hour)
        minute-with-decimal (* 60 fraction-of-hour)
        minute (int minute-with-decimal)
        fraction-of-minute (- minute-with-decimal minute)
        second (int (* 60 fraction-of-minute))]
    {:year year
     :month month
     :day day
     :hour hour
     :minute minute
     :second second}))

(defn vernal-equinox
  "Given a `year`, return a map with the Gregorian time of the vernal (March)
  equinox.
  See also: `jdn->gregorian-time`.
  Example: (vernal-equinox 2021)
  => {:year 2021, :month 3, :day 20, :hour 9, :minute 35, :second 35}"
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
    (jdn->gregorian-time jdn)))

(defn summer-solstice
  "Given a `year`, return a map with the Gregorian time of the summer (June)
  solstice.
  See also: `jdn->gregorian-time`.
  Example: (summer-solstice 2021)
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
    (jdn->gregorian-time jdn)))

(defn autumnal-equinox
  "Given a `year`, return a map with the Gregorian time of the autumnal
  (September) equinox.
  See also: `jdn->gregorian-time`.
  Example: (autumnal-equinox 2021)
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
    (jdn->gregorian-time jdn)))

(defn winter-solstice
  "Given a `year`, return a map with the Gregorian time of the winter (December)
  solstice.
  See also: `jdn->gregorian-time`.
  Example: (winter-solstice 2021)
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
    (jdn->gregorian-time jdn)))
