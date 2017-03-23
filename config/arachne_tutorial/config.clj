(ns ^:config arachne-tutorial.config
  (:require [arachne.core.dsl :as a]))

(a/id :myproj/foo (a/component 'arachne-tutorial.core/->Foo))

(a/id :myproj/widget-1 (a/component 'arachne-tutorial.core/make-widget
                                    {:foo  :myproj/foo}))

(a/id :myproj/runtime (a/runtime [:myproj/widget-1]))
