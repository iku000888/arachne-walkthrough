(ns arachne-tutorial.core
  (:require [arachne.log :as log]
            [com.stuartsierra.component :as c]))

(defrecord Foo []
  c/Lifecycle
  (start [this]
    (log/info :msg "foo starting")
    this)
  (stop [this]
    (log/info :msg "foo stopping")
    this))

(defrecord Widget [foo]
  c/Lifecycle
  (start [this]
    (log/info :msg (str "Hello, world!" (pr-str foo)))
    this)
  (stop [this]
    (log/info :msg (str "Goodnight!" (pr-str foo)) )
    this))

(defn make-widget
  "Constructor for a Widget"
  [foo]
  (map->Widget {:foo foo}))

(defn hello-handler
  [req]
  {:status 200
   :body "Hello, world!"})
#_(c/start (->Widget (->Foo)))
