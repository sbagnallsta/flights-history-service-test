package dbConnector

import (
	"gopkg.in/mgo.v2"
)

type DBData struct {
	Database string
	Collection string
	Session *mgo.Session 
}