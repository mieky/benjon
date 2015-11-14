(defproject benjon "0.1.0-SNAPSHOT"
  :description "a backend made of bensonite"
  :url "http://github.com/mieky/benjon"
  :min-lein-version "2.5.1"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.5"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler benjon.core/app}
  :main ^:skip-aot benjon.core
  :uberjar-name "benjon-standalone.jar"
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.3.0"]]}})
