package main

import (
	"bytes"
	"fmt"
	"io/ioutil"
	"os"
	"path/filepath"
	"strconv"
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
	Name       string      `yaml:"name"`
	SuperClass string      `yaml:"superClass"`
	Doc        string      `yaml:"doc"`
	Fields     []*FieldDef `yaml:"properties"`
}

// FieldDef is a field (property) declaration of a class.
type FieldDef struct {
	Name string `yaml:"name"`
	Type string `yaml:"type"`
	Doc  string `yaml:"doc"`
}

// EnumDef contains the definition of an enumeration.
type EnumDef struct {
	Name  string      `yaml:"name"`
	Doc   string      `yaml:"doc"`
	Items []*EnumItem `yaml:"items"`
}

// EnumItem is an item of an enumeration definition.
type EnumItem struct {
	Name string `yaml:"name"`
	Doc  string `yaml:"doc"`
}

func main() {

	if len(os.Args) < 2 {
		fmt.Println("ERROR: no path an olca-schema folder given")
		return
	}

	// parse the YAML files
	yamlDir := filepath.Join(os.Args[1], "yaml")
	files, err := ioutil.ReadDir(yamlDir)
	check(err, "failed to read YAML files from", yamlDir)
	types := make(map[string]*TypeDef)
	list := make([]*TypeDef, 0)
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
		list = append(list, typeDef)
	}
	fmt.Println("Collected", len(types), "types")

	// create the message types
	var buff bytes.Buffer
	for _, typeDef := range list {
		switch typeDef.name() {
		case "Entity", "RootEntity", "CategorizedEntity":
			continue
		}

		if typeDef.Class != nil {
			buff.WriteString("message " + typeDef.name() + " {\n\n")
			fields(typeDef.Class, &buff, types, 1)
			buff.WriteString("}\n\n")
		}
	}

	fmt.Println(buff.String())
}

func fields(class *ClassDef, buff *bytes.Buffer, types map[string]*TypeDef, offset int) int {
	count := offset
	if class.SuperClass != "" {
		super := types[class.SuperClass]
		if super != nil && super.Class != nil {
			count = fields(super.Class, buff, types, offset)
		}
	}

	if class.Name == "Entity" {
		buff.WriteString("  // The type name of the respectiven entity.\n")
		buff.WriteString("  // This field is used for JSON-LD compatibility.\n")
		buff.WriteString("  string type = " + strconv.Itoa(count))
		buff.WriteString(" [json_name = \"@type\"];\n\n")
		count++
	}

	if class.Name == "RootEntity" {
		buff.WriteString("  // The reference ID (typically an UUID) of the entity.\n")
		buff.WriteString("  string id = " + strconv.Itoa(count))
		buff.WriteString(" [json_name = \"@id\"];\n\n")
		count++
	}

	return count
}

func check(err error, msg ...interface{}) {
	if err != nil {
		fmt.Print("ERROR: ")
		fmt.Println(msg...)
		panic(err)
	}
}
