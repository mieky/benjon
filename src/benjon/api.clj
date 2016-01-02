(ns benjon.api
  (:require [clojure.java.io :as io]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [compojure.core :refer :all]
            [ring.middleware.multipart-params :as mp]            
            [benjon.db :as db]))

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