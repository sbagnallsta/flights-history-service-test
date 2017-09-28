package main 

import (
	"log"
	"time"
	"gopkg.in/mgo.v2"
	"github.com/gin-gonic/gin"
	"github.com/sta-travel/flights-history-service/service/profiles"
	"github.com/sta-travel/flights-history-service/service/models/dbConnector"
	"github.com/sta-travel/flights-history-service/service/controllers/health"
	"github.com/sta-travel/flights-history-service/service/controllers/flights"
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
