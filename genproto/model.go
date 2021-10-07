package main

// TypeDef contains the definition of a class or enumeration.
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
