package profiles

import (
	"log"
	"encoding/json"
	"os"
)

const fileExtension = ".json"
const local = "local"

type Configuration struct {
	Port               string
	DataSource              struct {
		Url string
		Database string
		Collection string
	}
}

func LoadConfiguration() Configuration {

	var config Configuration
	profile := getProfile()
	file := concatString(profile, fileExtension)
	relativeProfilePath := getGoPath(profile)
	absoluteProfilePath := concatString(os.Getenv("GOPATH"), relativeProfilePath)
	configFile, err := os.Open(concatString(absoluteProfilePath, file))
	defer configFile.Close()
	if err != nil {
		log.Println(err)
	}
	jsonParser := json.NewDecoder(configFile)
	jsonParser.Decode(&config)
	return config
}

func getProfile() string {

	profile := os.Getenv("FLIGHTS_HISTORY_SERVICE_PROFILE")

	if profile == "" {
		profile = local
	}

	return profile

}

func getGoPath(profile string) string {

	if profile == local {

		return "/src/github.com/sbagnallsta/flights-history-service-test/profiles//"
		// return "\\src\\github.com\\sta-travel\\flights-history-service\\profiles\\"

	}

	return "/src/github.com/sbagnallsta/flights-history-service-test/profiles/"

}

func concatString(string1 string, string2 string) string {

	return string1 + string(string2)

}
