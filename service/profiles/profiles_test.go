package profiles

import "testing"

func TestProfiles(t *testing.T) {

	var config Configuration
	config = LoadConfiguration()
	if config.Port != ":3200" && config.Port != ":3000" {
		t.Fatalf("Expecting config.port to be either ':3200' or ':3000' but was %v", config.Port)
	}

}