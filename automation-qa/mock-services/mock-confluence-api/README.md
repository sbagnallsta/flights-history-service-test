A service to mock the basic behaviour of the <a href="https://developer.atlassian.com/confdev/confluence-server-rest-api/confluence-rest-api-examples">Confluence API</a>

It runs on port 4100 

Will return 1 of two responses to the path 

<pre>/content</pre>

If the request contains the exact String <pre>"COPY"</pre>

It will return an Error that looks like the Confluence API Error Response:

<pre>
{
  "statusCode": 400,
  "data": {
    "authorized": false,
    "valid": true,
    "errors": [],
    "successful": false
  },
  "message": "Error message from the MOCK CONFLUENCE API"
}
</pre>

with Status: 400

Otherwise it will always return a simplified version of the Confluence API Success Response:

<pre>
{
  "id": "133343147",
  "type": "page",
  "status": "current",
  "title": "Success message from MOCK CONFLUENCE API"
 }
</pre>

with Status: 201