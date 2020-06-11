(defproject api2smtp "1.0.4"
  :description "Send emails through an Endpoint API"
  :url "https://github.com/tanrax/api2smtp"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [;; Clojure
                 [org.clojure/clojure "1.10.1"]
                 ;; Tadam core
                 [tadam-core "0.4.2"]
                 ;; HTTP Server
                 [ring "1.8.0"]
                 ;; Ring middleware that prevents CSRF attacks
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-anti-forgery "1.3.0"]
                 ;; Routing
                 [compojure "1.6.1"]
                 ;; Cors
                 [ring-cors "0.1.13"]
                 ;; Templates
                 [selmer "1.12.12"]
                 ;; Validations
                 [jkkramer/verily "0.6.0"]
                 ;; Yaml
                 [clj-yaml "0.4.0"]
                 ;; JSON encoding
                 [cheshire "5.9.0"]]
  :plugins [;; DEV TOOLS
            ;;; Check idiomatic bug
            [lein-kibit "0.1.7"]
            ;;; Check format
            [lein-cljfmt "0.6.4"]
            ;;; Generate documentation
            [lein-codox "0.10.7"]]
  ;; Map configuration for Ring
  :ring {:handler api2smtp.core.wrapped-handler}
  ;; ALIAS
  :aliases {"check-idiomatic" ["kibit" "src"]
            "check-format"    ["cljfmt" "check"]}
  ;; LEIN
  :main ^:skip-aot api2smtp.core
  :aot  [api2smtp.core]
  :repl-options {:init-ns api2smtp.core})
