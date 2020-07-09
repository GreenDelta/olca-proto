package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"path/filepath"
	"strings"

	yaml "gopkg.in/yaml.v2"
)

// TypeDef contains the defenition of a class or enumeration.
type TypeDef struct {
	Class *ClassDef `yaml:"class"`
	Enum  *EnumDef  `yaml:"enum"`
}

func (def *TypeDef) String() string {
	if def.Class != nil {
		return "ClassDef " + def.Class.Name
	}
	if def.Enum != nil {
		return "EnumDef " + def.Enum.Name
	}
	return "Unknown TypeDef"
}

func (def *TypeDef) name() string {
	if def.Class != nil {
		return def.Class.Name
	}
	if def.Enum != nil {
		return def.Enum.Name
	}
	return "Unknown"
}

// ClassDef contains the definition of a class.
type ClassDef struct {
	Name string `yaml:"name"`
}

// EnumDef contains the definition of an enumeration.
type EnumDef struct {
	Name string `yaml:"name"`
}

func main() {

	if len(os.Args) < 2 {
		fmt.Println("ERROR: no path an olca-schema folder given")
		return
	}

	yamlDir := filepath.Join(os.Args[1], "yaml")
	files, err := ioutil.ReadDir(yamlDir)
	check(err, "failed to read YAML files from", yamlDir)

	types := make(map[string]*TypeDef)
	for _, file := range files {
		name := file.Name()
		if !strings.HasSuffix(name, ".yaml") {
			continue
		}
		fmt.Println("Parse YAML file", name)
		path := filepath.Join(yamlDir, name)
		data, err := ioutil.ReadFile(path)
		check(err, "failed to read file", name)
		typeDef := &TypeDef{}
		err = yaml.Unmarshal(data, typeDef)
		check(err, "failed to parse file", name)
		fmt.Println("Parsed", typeDef)
		types[typeDef.name()] = typeDef
	}

	fmt.Println("Collected", len(types), "types")
}

func check(err error, msg ...interface{}) {
	if err != nil {
		fmt.Print("ERROR: ")
		fmt.Println(msg...)
		panic(err)
	}
}
