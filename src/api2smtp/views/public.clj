;;;; Views public web
(ns api2smtp.views.public
  (:require
   [tadam.templates :refer [render-template render-JSON]]
   [tadam.responses :refer [response]]
   [tadam.utils :refer [get-JSON]]
   [tadam.email :refer [send]]
   [api2smtp.config :refer [config]]))

(defn send-email
  ;; View Send email
  [req]
  (let [json   (get-JSON req)
        params {:name    (-> json :name)
                :subject (-> json :subject)
                :email   (-> json :email)
                :message (-> json :message)}]
    ;; Send email
    (send config (:smtp-to config) (:smtp-subject config) (render-template "emails/contact.html" params) (render-template "emails/contact.txt" params))

    ;; Response OK
    (render-JSON req {:status "ok"})))

(defn error
  ;; View page 404
  [req]

  ;; Response ERROR
  (response req "{\"status\": \"error\"}" 500 "text/json;charset=utf-8"))
