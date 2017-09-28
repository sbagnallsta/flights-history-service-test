package flightController

import (
	"net/http"
	"github.com/gin-gonic/gin"
	"github.com/sta-travel/flights-history-service/service/repository"
	"github.com/sta-travel/flights-history-service/service/models/dbConnector"
	"github.com/sta-travel/flights-history-service/service/models/flight"
)

func StoreFlights(dbConnector dbConnector.DBData) gin.HandlerFunc {

	function := func(context *gin.Context) {

		var data []flight.Flight

		context.BindJSON(&data)

		go flightsRepository.SaveFlight(dbConnector, data) 

		context.Status(http.StatusCreated)

	}

	return gin.HandlerFunc(function)
}

