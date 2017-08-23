package main 

import (
	"log"
	"time"
	"gopkg.in/mgo.v2"
	"github.com/gin-gonic/gin"
	"github.com/sbagnallsta/flights-history-service-test/profiles"
	"github.com/sbagnallsta/flights-history-service-test/models/dbConnector"
	"github.com/sbagnallsta/flights-history-service-test/controllers/health"
	"github.com/sbagnallsta/flights-history-service-test/controllers/flights"
)

func main() {
	config := profiles.LoadConfiguration()
	router := gin.Default()

	mongoInfo := &mgo.DialInfo {
		Addrs: []string{config.DataSource.Url},
		Timeout: 60 * time.Second,
	}

	session, err := mgo.DialWithInfo(mongoInfo)

	if err != nil {
		log.Fatal("Failed to connect to mongoDB ", err)
	}

	db := dbConnector.DBData{config.DataSource.Database, config.DataSource.Collection, session}

	router.GET("/health", healthController.Health)

	flights := router.Group("/flights")
	{
		flights.POST("", flightController.StoreFlights(db))
	}

	router.Run(config.Port)
}
