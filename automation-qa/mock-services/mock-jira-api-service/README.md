Service to Mock the behaviour of the Jira API

***NOTE by default this runs on port 3082 NOT 3081 (3081 should be reserved for a mock Jira service, this is a mock Jira API service)***

this service has three end points, one for GETing PROJECTS one for GETing VERSIONS and one for PUTing to VERSIONS:

=================================The PROJECTS endpoint===================================

`localhost:3082/rest/api/2/project/{projectName}/versions`

a valid GET request to this endpoint is currently when projectName = `unreleased` or `released`

a request to `released` will return a project with `"released": true`
a request to `unreleased` will return a project with `"released": false`

ie `localhost:3082/rest/api/2/project/unreleased/versions`

will return a 200 with the following body:
    
`[
  {
    "self": "https://statravel.atlassian.net/rest/api/2/version/15801",
    "id": "15801",
    "name": "Admin UI v1.32",
    "archived": false,
    "released": true,
    "startDate": "2016-02-22",
    "releaseDate": "2016-03-09",
    "userStartDate": "22/Feb/16",
    "userReleaseDate": "09/Mar/16",
    "projectId": 10003
  },
  {
    "self": "https://statravel.atlassian.net/rest/api/2/version/15900",
    "id": "15900",
    "name": "JS Components 1.28",
    "archived": false,
    "released": true,
    "startDate": "2016-02-22",
    "releaseDate": "2016-03-09",
    "userStartDate": "22/Feb/16",
    "userReleaseDate": "09/Mar/16",
    "projectId": 10003
  }
]`

any other request, such as when projectName = `some-value-here` 

ie `localhost:3082/rest/api/2/project/some-value-here/versions`

will return a 404 with the following body:

`{
  "errorMessages": [
    "No project could be found with key 'some-value-here'."
  ],
  "warningMessages": []
}`

=============================The getting VERSIONS endpoint=======================================

The actual Jira API versions endpoint returns a massive json object (almost 250 lines)
This mock service returns a scaled down version of this object

`localhost:3082/rest/api/2/search?jql=fixVersion={versionName}`

a valid GET request is currently when versionName = `unreleased` OR versionName = `released`

if the versionName is `unreleased` you will get back an object with `"released":false`
if the versionName is `released` you will get back an object with `"released":true`

ie `localhost:3082/rest/api/2/search?jql=fixVersion=released`

will return a 200 with the following body:

`{
  "total": 2,
  "issues": [
    {
      "id": "released",
      "key": "released",
      "fields": {
        "fixVersions": [
          {
            "name": "Testing Release NAME",
            "archived": false,
            "released": true
          }
        ],
        "customfield_11700": "Testing Release DESCRIPTION"
      }
    }
  ]
}`

any other request will get an error 400

ie a GET to `localhost:3082/rest/api/2/search?jql=fixVersion=released 1234`

will return

`{
  "errorMessages": [
    "The value 'released 1234' does not exist for the field 'fixVersion'."
  ]
}`

=============================The updating VERSIONS endpoint=======================================

`localhost:3082/rest/api/2/version/{version}`

a valid PUT request is where version is `unreleased` or `released`

you PUT a json object where "released" is true or false

ie PUT 

`{
    "released": false   
}` 

will return 

`{
  "self": "https://statravel.atlassian.net/rest/api/2/version/released",
  "id": "released",
  "description": "Testing Release",
  "name": "Testing Release",
  "released": false,
  "projectId": 10003
}`

a request to any other end point will return an error

ie PUT

`{
    "released":true
}`

to

`localhost:3082/rest/api/2/version/anything else`

will return 

`{
  "errorMessages": [
    "Could not find version for id ' anything else'"
  ]
}`
