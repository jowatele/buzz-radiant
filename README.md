[![Heroku CI Status](https://buzz-radiant-heroku-ci-badge.herokuapp.com/last.svg)](https://dashboard.heroku.com/pipelines/buzz-pipe/tests)

## Config ##

All information to get your auth key is on https://apps.twitter.com/

Create an application, copy consumer key and consumer secret.

Create access token for your account, copy access token and access token secret.

Copy `src/main/resources/twitter.conf.template` to `src/main/resources/twitter.conf` and fill in above keys/tokens/secrets.

Run with `sbt run`