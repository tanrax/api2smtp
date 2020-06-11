;;;; Views public web
(ns api2smtp.views.public
  (:require
   [tadam.templates :refer [render-template render-JSON]]
   [tadam.responses :refer [response]]
   [tadam.email :refer [send]]))

(defn send
  ;; View Send email
  [req]
  (let [params {:name    (-> req :params :name)
                :subject (-> req :params :subject)
                :email   (-> req :params :email)
                :message (-> req :params :message)}]
    ;; Send email
    (send "to@email.com" "Contact" (render-template "emails/contact.html" params) (render-template "emails/contact.txt" params))

    ;; Response OK
    (render-JSON req {:status "ok"})))

(defn error
  ;; View page 404
  [req]

  ;; Response ERROR
  (response req "{\"status\": \"error\"}" 500 "text/json;charset=utf-8"))
