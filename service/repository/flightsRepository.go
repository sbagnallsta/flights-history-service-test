package flightsRepository

import (
	"log"
	"github.com/sta-travel/flights-history-service/service/models/flight"
	"github.com/sta-travel/flights-history-service/service/models/dbConnector"
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