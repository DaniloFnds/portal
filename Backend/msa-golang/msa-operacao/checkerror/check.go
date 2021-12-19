package checkerror

import (
	"log"
)

func CheckErrorFatal(err error) {
	if err != nil {
		log.Fatal(err)
	}
}

func CheckErrorObject(v interface{}, err error) interface{} {
	if err != nil {
		log.Fatal(err)
	}
	return v
}
