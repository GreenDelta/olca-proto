package main

import (
	"bytes"
	"fmt"
	"io/ioutil"
	"os"
	"path/filepath"
	"strconv"
	"strings"
	"unicode"

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
	buff.WriteString(`syntax = "proto3";
option java_package = "org.openlca.proto";
option java_outer_classname = "Proto";

`)
	for _, typeDef := range list {
		switch typeDef.name() {
		case "Entity", "RootEntity", "CategorizedEntity":
			continue
		}

		class := typeDef.Class
		if class != nil {

			comment := formatComment(class.Doc, "")
			if comment != "" {
				buff.WriteString(comment)
			}
			buff.WriteString("message " + typeDef.name() + " {\n\n")
			fields(class, &buff, types, 1)
			buff.WriteString("}\n\n")
		}
	}

	// print to console or write to file
	if len(os.Args) < 3 {
		fmt.Println(buff.String())
	} else {
		outFile := os.Args[2]
		err = ioutil.WriteFile(outFile, buff.Bytes(), os.ModePerm)
		check(err, "failed to write to file", outFile)
	}
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

	for _, field := range class.Fields {
		comment := formatComment(field.Doc, "  ")
		if comment != "" {
			buff.WriteString(comment)
		}
		buff.WriteString("  " + mapType(field.Type) + " " + field.Name +
			" = " + strconv.Itoa(count) + ";\n\n")
		count++
	}

	return count
}

func mapType(schemaType string) string {
	switch schemaType {
	case "string", "double", "float":
		return schemaType
	case "dateTime", "date":
		return "string"
	case "int", "integer":
		return "int32"
	case "boolean":
		return "bool"
	}

	if strings.HasPrefix(schemaType, "Ref[") {
		return "Ref"
	}

	if strings.HasPrefix(schemaType, "List[") {
		t := strings.TrimSuffix(
			strings.TrimPrefix(schemaType, "List["), "]")
		return "repeated " + mapType(t)
	}

	return schemaType
}

func formatComment(comment string, indent string) string {
	if strings.TrimSpace(comment) == "" {
		return ""
	}

	// split words by whitespaces
	var words []string
	var word bytes.Buffer
	for _, char := range comment {
		if unicode.IsSpace(char) {
			if word.Len() > 0 {
				words = append(words, word.String())
			}
			word.Reset()
			continue
		}
		word.WriteRune(char)
	}
	if word.Len() > 0 {
		words = append(words, word.String())
	}
	if len(words) == 0 {
		return ""
	}

	// format the comment
	text := ""
	line := indent + "//"
	for _, word := range words {
		nextLine := line + " " + word
		if len(nextLine) < 80 {
			line = nextLine
		} else {
			text += line + "\n"
			line = indent + "// " + word
		}
	}
	if line != indent+"// " {
		text += line + "\n"
	}
	return text
}

func check(err error, msg ...interface{}) {
	if err != nil {
		fmt.Print("ERROR: ")
		fmt.Println(msg...)
		panic(err)
	}
}
