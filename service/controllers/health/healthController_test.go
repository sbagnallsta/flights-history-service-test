package healthController

import (
	"testing"
	"github.com/gin-gonic/gin"
	"net/http"
	"net/http/httptest"
)

func TestHealthController(t *testing.T) {

	router := gin.New()
	router.GET("/health", Health)

	req, _ := http.NewRequest("GET", "/health", nil)
	resp := httptest.NewRecorder()

	router.ServeHTTP(resp, req)

	if resp.Code != 200 {
		t.Fatalf("Non-expected status code%v:\n\tbody: %v", "200", resp.Code)
	}

}
