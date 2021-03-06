(ns twitter.api.streaming
  (:require [twitter.callbacks :refer :all]
            [twitter.core :refer :all])
  (:import twitter.api.ApiContext))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def ^:dynamic *streaming-api* (ApiContext. "https" "stream.twitter.com" "1.1"))

(defmacro def-twitter-streaming-method
  "defines a streaming API method using the above api context"
  [name verb resource-path & rest]

  `(def-twitter-method ~name ~verb ~resource-path :api ~*streaming-api* :callbacks (get-default-callbacks :async :streaming) ~@rest))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def-twitter-streaming-method statuses-filter :post "statuses/filter.json")
(def-twitter-streaming-method statuses-firehose :get "statuses/firehose.json")
(def-twitter-streaming-method statuses-sample :get "statuses/sample.json")

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def ^:dynamic *user-stream-api* (ApiContext. "https" "userstream.twitter.com" 1.1))

(defmacro def-twitter-user-streaming-method
  "defines a user streaming method using the above context"
  [name verb resource-path & rest]

  `(def-twitter-method ~name ~verb ~resource-path :api ~*user-stream-api* :callbacks (get-default-callbacks :async :streaming) ~@rest))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def-twitter-user-streaming-method user-stream :get "user.json")

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def ^:dynamic *site-stream-api* (ApiContext. "https" "sitestream.twitter.com" "1.1"))

(defmacro def-twitter-site-streaming-method
  "defines a site streaming method using the above context"
  [name verb resource-path & rest]

  `(def-twitter-method ~name ~verb ~resource-path :api ~*site-stream-api* :callbacks (get-default-callbacks :async :streaming) ~@rest))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def-twitter-site-streaming-method site-stream :get "site.json")

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
