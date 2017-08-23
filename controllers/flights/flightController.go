package flightController

import (
	"net/http"
	"github.com/gin-gonic/gin"
	"github.com/sbagnallsta/flights-history-service-test/repository"
	"github.com/sbagnallsta/flights-history-service-test/models/dbConnector"
	"github.com/sbagnallsta/flights-history-service-test/models/flight"
)

func StoreFlights(dbConnector dbConnector.DBData) gin.HandlerFunc {

	function := func(context *gin.Context) {

		var data []flight.Flight

		context.BindJSON(&data)

		go flights.SaveFlight(dbConnector, data) 

		context.Status(http.StatusCreated)

	}

	return gin.HandlerFunc(function)
}

