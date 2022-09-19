# Data validator
Data validator is a library for checking data correctness.

Choose the schema, use one or more validators if necessary, validate an input.
To build a schema chain methods together.

This project is written with the object-oriented approach in mind.
The implementation is largely based on the fluent-interface pattern.
I use Gradle as a build automation tool. GitHub Actions acts as a continuous integration (CI) platform.
The JUnit framework is used to write tests. I also use Make & Makefile for frequently used commands in order to save time.

### Hexlet tests and linter status:
[![Actions Status](https://github.com/hopetoknow/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/hopetoknow/java-project-78/actions)

### GitHub Actions workflow status badge
[![Java CI](https://github.com/hopetoknow/java-project-78/actions/workflows/main.yml/badge.svg?branch=main)](https://github.com/hopetoknow/java-project-78/actions/workflows/main.yml)

### Maintainability badge from Code Climate
[![Maintainability](https://api.codeclimate.com/v1/badges/fee4d924514e71c4ae12/maintainability)](https://codeclimate.com/github/hopetoknow/java-project-78/maintainability)

### Test Coverage badge from Code Climate
[![Test Coverage](https://api.codeclimate.com/v1/badges/fee4d924514e71c4ae12/test_coverage)](https://codeclimate.com/github/hopetoknow/java-project-78/test_coverage)

## Usage example
```sh
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

Validator v = new Validator();

// String
StringSchema schema = v.string().required();

schema.isValid("four out of five"); // true
schema.isValid(""); // false 
schema.contains("fourout").isValid("four out of five")); // false
schema.minLength(2).isValid("fourout") // true

// Number
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true
schema.range(20, 30).isValid(10); // false

// Map object with support for validation of nested data
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Alex");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human1); // false
```

## Build
```sh
make build
```

## Run tests
```sh
make test
```

## Run checkstyle
```sh
make lint
```

## Check for Dependency Updates
```sh
make check-updates
```