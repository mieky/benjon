(ns benjon.core
  (:require [clojure.java.io :as io]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [compojure.core :refer :all]
            [org.httpkit.server :refer [run-server]]
            [ring.middleware.multipart-params :as mp]
            [benjon.db :as db])
  (:gen-class))

(defn get-server-port []
  (let [port (System/getenv "PORT")]
    (if (nil? port)
      3000
      (Integer/parseInt port))))

(defn upload-file [file]
  (let [tempfile (get file :tempfile)
        filename (get file :filename)
        targetfile (io/file "resources" "public" filename)]
    (println (str "tempfile: " tempfile " filename: " filename))
    (io/make-parents targetfile)
    (io/copy tempfile targetfile)
    "Success!"))

(defroutes app-routes
  (GET "/" [] "Hello root!")
  (mp/wrap-multipart-params
    (POST "/upload" {params :params}
      (upload-file (get params "file"))))
  (route/not-found "Not Found"))

(defn -main
  [& args]
  (let [port (get-server-port)]
    (println (format "Starting server at localhost:%s..." port))
    (run-server app-routes {:port port})))
