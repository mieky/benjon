(ns benjon.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]])
  (:gen-class))

(defroutes app-routes
  (GET "/" [] "Hello world!")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Note to self: implement API"))
