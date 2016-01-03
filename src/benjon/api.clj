(ns benjon.api
  (:require [clojure.java.io :as io]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [compojure.core :refer :all]
            [cheshire.core :refer :all]
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

(defroutes api-routes
  (GET "/api" [] "Hello root!")
  (GET "/api/message" []
    (generate-string (db/messages)))
  (mp/wrap-multipart-params
    (POST "/api/upload" {params :params}
      (upload-file (get params "file"))))
  (route/not-found "Not Found"))
