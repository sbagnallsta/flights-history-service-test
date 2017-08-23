package flights

import (
	"log"
	"github.com/sbagnallsta/flights-history-service-test/models/flight"
	"github.com/sbagnallsta/flights-history-service-test/models/dbConnector"
)

func SaveFlight(dbConnector dbConnector.DBData, data []flight.Flight) {

	sessionCopy := dbConnector.Session.Copy()
	defer sessionCopy.Close()

	db := sessionCopy.DB(dbConnector.Database).C(dbConnector.Collection)

	for _, elem := range data {

		err := db.Insert(elem)

		if err != nil {
			log.Printf("Failed to insert %v due to %v", elem, err)
		}

	}

}