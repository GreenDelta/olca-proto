package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"path/filepath"
	"strings"
)

func main() {

	if len(os.Args) < 2 {
		fmt.Println("ERROR: no path an olca-schema folder given")
		return
	}

	yamlDir := filepath.Join(os.Args[1], "yaml")
	files, err := ioutil.ReadDir(yamlDir)
	check(err, "failed to read YAML files from", yamlDir)
	for _, file := range files {
		name := file.Name()
		if !strings.HasSuffix(name, ".yaml") {
			continue
		}
		fmt.Println("Parse YAML file", name)
	}
}

func check(err error, msg ...interface{}) {
	if err != nil {
		fmt.Print("ERROR: ")
		fmt.Println(msg...)
		panic(err)
	}
}
