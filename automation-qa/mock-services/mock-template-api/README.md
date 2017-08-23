Service that mocks the behaviour of the Template Service API

runs on port 3041

Will return 1 of two responses to the path

<pre>/templates</pre>

the application will validate the POST request like the service it mocks, so a request like

<pre>
{
    "title": "title",
    "product": "Saved Searches API",
    "type": "Release",
    "space": "space",
    "team": null,
    "templateObject": {
        "team": "Internal",
        "product": "Saved Searches",
        "version": "1.4",
        "githubTag": "release-1.4",
        "changeRequestNumber":"CHF1234"
        }
}
</pre>


will return an Error that looks like the Template Service API Error Response:

<pre>
{
    "errors":[
        {
        "path":"team",
        "keyword":"type"
        }
    ]
}
</pre>

with Status: 400

Any valid request will always recieve the following:

<pre>
{
  "data": {
    "treeStructure": "Release Management - Release History - Saved Searches API - ",
    "parentId": 107937830,
    "template": "&lt;h1&gt;Release Summary&lt;/h1&gt;&lt;p&gt;&lt;br /&gt;&lt;/p&gt;&lt;table class=\&quot;wrapped confluenceTable\&quot;&gt;&lt;colgroup&gt;&lt;col /&gt;&lt;col /&gt;&lt;/colgroup&gt;&lt;tbody&gt;&lt;tr&gt;&lt;th class=\&quot;confluenceTh\&quot;&gt;Team&lt;/th&gt;&lt;td class=\&quot;confluenceTd\&quot;&gt;&lt;p&gt;Internal&lt;/p&gt;&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;th class=\&quot;confluenceTh\&quot;&gt;&lt;p&gt;Product&lt;/p&gt;&lt;/th&gt;&lt;td class=\&quot;confluenceTd\&quot;&gt;&lt;p&gt;Saved Searches&lt;/p&gt;&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;th class=\&quot;confluenceTh\&quot;&gt;&lt;p&gt;Release Version&lt;/p&gt;&lt;/th&gt;&lt;td class=\&quot;confluenceTd\&quot;&gt;&lt;p&gt;1.4&lt;/p&gt;&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;th colspan=\&quot;1\&quot; class=\&quot;confluenceTh\&quot;&gt;GitHub Tag&lt;/th&gt;&lt;td colspan=\&quot;1\&quot; class=\&quot;confluenceTd\&quot;&gt;&lt;p&gt;release-1.4&lt;/p&gt;&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;th colspan=\&quot;1\&quot; class=\&quot;confluenceTh\&quot;&gt;Change Request Number&lt;/th&gt;&lt;td colspan=\&quot;1\&quot; class=\&quot;confluenceTd\&quot;&gt;&lt;p&gt;CHF1234&lt;/p&gt;&lt;/td&gt;&lt;/tr&gt;&lt;/tbody&gt;&lt;/table&gt;&lt;h1&gt;Features&lt;/h1&gt;&lt;h1&gt;Known Issues&lt;/h1&gt;&lt;p&gt;&lt;br /&gt;&lt;/p&gt;&lt;p&gt;&amp;nbsp;&lt;/p&gt;"
  }
}
</pre>

with Status: 201
