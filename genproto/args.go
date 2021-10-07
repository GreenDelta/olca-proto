package main

import (
	"fmt"
	"os"
	"path/filepath"
)

func findYamlDir() string {
	home := findSchemaHome()
	yamlDir := filepath.Join(home, "yaml")
	if !isDir(yamlDir) {
		fmt.Println("error: `yaml` folder does not exist:", yamlDir)
		os.Exit(1)
	}
	return yamlDir
}

// Searches for the `olca-schema` folder. It can be provided
// as the first command line argument, or we search for it
// up in the file hierarchy.
func findSchemaHome() string {
	if len(os.Args) > 1 {
		home := os.Args[1]
		if !isDir(home) {
			fmt.Println("error: the first argument does" +
				" not point to a `olca-schema` folder")
			os.Exit(1)
		}
		return home
	}
	dir, err := filepath.Abs(".")
	check(err)
	for {
		path := filepath.Join(dir, "olca-schema")
		if isDir(path) {
			return path
		}
		parent := filepath.Dir(dir)
		if parent == dir {
			fmt.Println("error: could not find an `olca-schema`" +
				" folder up in the file hierarchy")
			os.Exit(1)
		}
		dir = parent
	}
}

func isDir(path string) bool {
	info, err := os.Stat(path)
	return err == nil && info.IsDir()
}
