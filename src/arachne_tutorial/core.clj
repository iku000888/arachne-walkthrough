(ns arachne-tutorial.core
  (:require [arachne.log :as log]
            [com.stuartsierra.component :as c]))


(defrecord Widget []
  c/Lifecycle
  (start [this]
    (log/info :msg "Hello, world!")
    this)
  (stop [this]
    (log/info :msg "Goodnight!")
    this))

(defn make-widget
  "Constructor for a Widget"
  []
  (->Widget))
