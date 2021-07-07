(defproject xyz.thoren/equinox "0.1.2-SNAPSHOT"
  :description "Calculate equinoxes and solstices for a given year"
  :url "https://github.com/johanthoren/equinox"
  :license {:name "ISC"
            :url "https://choosealicense.com/licenses/isc"
            :comment "ISC License"
            :year 2021
            :key "isc"}
  :dependencies [[org.clojure/clojure "1.10.3"]]
  :repl-options {:init-ns xyz.thoren.equinox}
  :repositories [["releases" {:url "https://repo.clojars.org"
                              :creds :gpg}]]
  :release-tasks [["test"]
                  ["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag"]
                  ["deploy"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]])
