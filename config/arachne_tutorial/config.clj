(ns ^:config arachne-tutorial.config
  (:require [arachne.core.dsl :as a]))

(a/id :myproj/widget-1 (a/component 'arachne-tutorial.core/make-widget))

(a/id :myproj/runtime (a/runtime [:myproj/widget-1]))
