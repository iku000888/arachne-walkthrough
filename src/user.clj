(ns user
  (:require [arachne.core :as ac]
            [com.stuartsierra.component :as c]))

(def app nil)

(defn boot-app []
  (let [new-app (-> :myproj/app
                    ac/config
                    (ac/runtime :myproj/runtime))]
    (when app (c/stop app))
    (intern *ns* 'app new-app)
    (c/start app)))
