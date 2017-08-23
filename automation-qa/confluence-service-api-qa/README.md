An application to test the Confluence Cloud manager

run with <pre>mvn clean install -Dcucumber.options="--tags ${tag}" -Dspring.profiles.active=${profile}</pre>

where ${tag} can be @smoke for smoke testing (ie all tests), @negative for testing errors, @positive for testing success, or @pageresource for all tests related to the construction of confluence pages.

running mvn clean install will run all tests


