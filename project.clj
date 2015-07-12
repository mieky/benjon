(defproject benjon "0.1.0-SNAPSHOT"
  :description "a backend made of bensonite"
  :url "http://github.com/mieky/benjon"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot benjon.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
