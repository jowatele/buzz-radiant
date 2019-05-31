[![Build Status](https://travis-ci.com/jwatelet/buzz-radiant.svg?branch=master)](https://travis-ci.com/jwatelet/buzz-radiant)

## Config ##

All information to get your auth key is on https://apps.twitter.com/

Create an application, copy consumer key and consumer secret.

Create access token for your account, copy access token and access token secret.

Copy `src/main/resources/twitter.conf.template` to `src/main/resources/twitter.conf` and fill in above keys/tokens/secrets.

Run with `sbt run`


## Get Started ##

##### Init the observer

`curl -X POST http://localhost:8080/observers  -d '["#Scala"]`
   
##### Get all observersIds
  
`curl -X GET http://localhost:8080/observers`

##### Get Statistics from the observer

`curl -X GET  'http://localhost:8080/observers/{observerId}/tweets/statistics`

##### Get statistics from the websocket

`ws://localhost:8080/observers/{observerId}/tweets/statistics/ws`

## TODO ##

- [X] sentiment detection V1
- [ ] Sentiment detection V2
- [ ] Top Tweet user for a buzz
- [ ] Top Hashtags