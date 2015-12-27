(ns benjon.core
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [compojure.core :refer :all]
            [clojure.java.io :as io]
            (ring.middleware [multipart-params :as mp]))
  (:gen-class))

(defn upload-file [file]
  (let [tempfile (get file :tempfile)
        filename (get file :filename)]
    (println (str "tempfile: " tempfile " filename: " filename))
    (io/copy tempfile (io/file "resources" "public" filename))
    "Success!"))

(defroutes app-routes
  (GET "/" [] "Hello root!")
  (mp/wrap-multipart-params
    (POST "/upload" {params :params}
      (upload-file (get params "file"))))
  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Note to self: implement API"))
