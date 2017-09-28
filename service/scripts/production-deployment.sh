#!/bin/bash.

curl -H "Authorization:Token $WORKFLOW_CONTROLLER_API_PRODUCTION_TOKEN" -H "Content-Type:application/json" /
-X POST http://deis.104.40.177.64.nip.io/v2/apps/flights-history-service/builds /
-d '{"image":"statravel/flights-history-service:'$1'"}'
