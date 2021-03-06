(defproject benjon "0.1.0"
  :description "a backend made of bensonite"
  :url "http://github.com/mieky/benjon"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/data.json "0.2.5"]
                 [compojure "1.4.0"]
                 [http-kit "2.1.18"]
                 [yesql "0.5.1"]
                 [ring-middleware-format "0.7.0"]
                 [org.postgresql/postgresql "9.4-1206-jdbc41"]
                 [cheshire "5.5.0"]]
  :main ^:skip-aot benjon.core
  :uberjar-name "benjon-standalone.jar"
  :min-lein-version "2.5.1"
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.3.0"]]}})
