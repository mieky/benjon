(ns benjon.routes
  (:require [clojure.java.io :as io]
            [compojure.route :as route]
            [compojure.core :refer :all]
            [ring.middleware.multipart-params :as mp]
            [ring.middleware.format :refer [wrap-restful-format]]
            [benjon.db :as db]))

(defn upload-file [file]
  (let [tempfile (get file :tempfile)
        filename (get file :filename)
        targetfile (io/file "resources" "public" filename)]
    (println (str "tempfile: " tempfile " filename: " filename))
    (io/make-parents targetfile)
    (io/copy tempfile targetfile)
    "Success!"))

(defn post-message [params]
  (println "post-message:" params)
  (let [uuid (db/uuid)
        rows (db/new-message! {:id uuid
                               :author_id "c43e4bb6-d04b-4d66-bc5d-bc43296ec15c"
                               :message (get params "message")})]
    (db/message-by-id {:id uuid})))

(defn dump-req [req]
  (str "Request: " req))

(defroutes api-routes
  (GET "/api" [] "Hello root!")
  (GET "/api/test" req (dump-req req))
  (POST "/api/test" req (dump-req req))

  ; let wrap-restful-format middleware take care of serialization,
  ; no more need for (json-response (generate-string (db/messages)))))
  (GET "/api/message" [] (db/messages))
  (POST "/api/message" {params :params} (post-message params))
  (POST "/api/upload" {params :params} (upload-file (get params "file")))

  (route/not-found "Not Found"))

(def site
  (-> api-routes
      (mp/wrap-multipart-params)
      (wrap-restful-format)))
