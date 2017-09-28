#!/bin/bash.

curl -H "Authorization:Token $WORKFLOW_CONTROLLER_API_STAGING_TOKEN" -H "Content-Type:application/json" /
-X POST http://deis.40.68.36.110.nip.io/v2/apps/flights-history-service/builds /
-d '{"image":"statravel/flights-history-service:'$1'"}'
