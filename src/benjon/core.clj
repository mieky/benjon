(ns benjon.core
  (:require [org.httpkit.server :refer [run-server]]
            [benjon.api :as api])
  (:gen-class))

(defn get-server-port []
  (let [port (System/getenv "PORT")]
    (if (nil? port)
      3000
      (Integer/parseInt port))))

(defn -main
  [& args]
  (let [port (get-server-port)]
    (println (format "Starting server at localhost:%s..." port))
    (run-server api/app-routes {:port port})))
