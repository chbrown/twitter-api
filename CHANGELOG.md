# twitter-api changelog

## 0.7.7
* Add `org.clojure/data.codec` dependency and implement app-only authentication with tests
* Handle rate-limit error responses
* Update:
  - `org.clojure/clojure` 1.4.0 -> 1.6.0
  - `org.clojure/data.json` 0.2.1 -> 0.2.5
  - `clj-oauth` 1.4.0 -> 1.5.1
* Add `site-stream` streaming method

## 0.7.6
* Update `http.async.client` dependency to fix problem with uploading
* Add `lists/ownerships` restful method

## 0.7.5
* changed all URLs to use https scheme (thanks tjoy)

## 0.7.4
* removed the dependency to adamwynne/clj-oauth and moved to main clj-oauth
* removed the user suggestion tests as the endpoint seems down

## 0.7.3
* removed some extraneous .json's in uris (thanks Takahiro Hozumi)

## 0.7.2
* upgraded the lein dependency to 2 (and removed the plugins - should be .lein/profiles.clj)
* upgraded the async library to 0.5.0

## 0.7.1
* bumped the search api version to 1.1 (thanks Aaron Steele)
* incorporated some recommendations from Kibit (thanks Seymores)

## 0.7.0
* BREAKING CHANGE: changed the REST function naming convention to the one described in the readme
* updated the tests to reflect the new function names
* added this changelog (recursive overload!)
