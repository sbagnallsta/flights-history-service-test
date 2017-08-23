package routes

import (
	"github.com/sbagnallsta/flights-history-service-test/healthController"
	"github.com/gin-gonic/gin"
)

func InitializeRouter() *gin.Engine {

	router := gin.Default()

	router.GET("/health", healthController.Health)

	return router

}