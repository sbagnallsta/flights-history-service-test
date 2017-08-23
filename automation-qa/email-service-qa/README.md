A Service for automatically testing the email-service's API

run the sanity test with
mvn clean test -DargLine="-Dspring.profiles.active={profile}" -Dcucumber.options="--tags @sanity"

run the smoke tests with
mvn clean test -DargLine="-Dspring.profiles.active={profile}" -Dcucumber.options="--tags @smoke"

where {profile} can be local, ci or staging.

The application requires both the email-service and the template-service to be running

===================WARNING===================
some of the tests depend on a database being in the right state. Because the application does not yet have liquibase set up failing tests could be due to not having the correct enteries in the database 