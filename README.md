# Data validator
Data validator is a library for checking data correctness.

Define the schema, use one or more validators if necessary, validate an input.
Chain together methods to build a schema.

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