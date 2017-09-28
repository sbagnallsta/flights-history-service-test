A Service for automatically testing the flights-history-service's API

run the sanity test with
mvn clean test -DargLine="-Dspring.profiles.active={profile}" -Dcucumber.options="--tags @sanity"

run the smoke tests with
mvn clean test -DargLine="-Dspring.profiles.active={profile}" -Dcucumber.options="--tags @smoke"

where {profile} can be local, ci or staging.

The application requires the flights-history-service to be listening on port 3200 when run locally

===================WARNING===================
some of the tests depend on a database being in the right state. Because the application does not yet have liquibase set up failing tests could be due to not having the correct enteries in the database 