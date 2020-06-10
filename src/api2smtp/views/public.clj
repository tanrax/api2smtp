;;;; Views public web
(ns api2smtp.views.public
  (:require
   [tadam.templates :refer [render-JSON]]
   [tadam.responses :refer [response]]))

(defn index
  ;; View HTML
  [req]
  (let [name    (-> :params :name)
        subject (-> :params :subject)
        email   (-> :params :email)
        message (-> :params :message)]

    (render-JSON req {:status "ok"})))

(defn page-404
  ;; View page 404
  [req]
  (response req "{\"status\": \"error\"}" 500 "text/json;charset=utf-8"))
