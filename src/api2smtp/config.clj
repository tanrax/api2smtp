(ns api2smtp.config
    (:require
     [clj-yaml.core :as yaml]))

(def config (yaml/parse-string (slurp "config.yaml")))
