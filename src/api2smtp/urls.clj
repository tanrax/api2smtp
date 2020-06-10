(ns api2smtp.urls
  (:require
   [compojure.core :refer [defroutes POST]]
   [compojure.route :as route]
   [api2smtp.views.public :as view-public]))

(defroutes public
  ;; Urls public pages
  (POST "/api/v1/email/" [] view-public/index))


(defroutes resources-routes
  ;; Resources (statics)
  (route/resources "/")
  (route/not-found view-public/page-404))

(def all-routes
  ;; Wrap routers. "resources-routes" should always be the last.
  (compojure.core/routes public resources-routes))
