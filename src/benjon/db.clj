(ns benjon.db
  (:require [yesql.core :refer [defqueries]]))

(def db-spec
  {:user "benjon"
   :password "benjon"
   :subname "//localhost/benjon"
   :port "5432"
   :subprotocol "postgresql"})

(defqueries "sql/queries.sql" {:connection db-spec})

(defn show-messages []
  (messages))

(messages)
