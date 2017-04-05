(ns ^:config arachne-tutorial.config
  (:require [arachne.core.dsl :as a]
            [arachne.http.dsl :as http]
            [arachne.pedestal.dsl :as pedestal]))

(a/id :myproj/foo (a/component 'arachne-tutorial.core/->Foo))

(a/id :myproj/widget-1 (a/component 'arachne-tutorial.core/make-widget
                                    {:foo  :myproj/foo}))

(a/id :myproj/hello (http/handler 'arachne-tutorial.core/hello-handler))

(a/id :myproj/server
      (pedestal/server
       8087
       (http/endpoint :get "/" :myproj/hello)))

(a/id :myproj/runtime (a/runtime [:myproj/server]))
