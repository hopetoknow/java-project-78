check-updates:
	./gradlew dependencyUpdates

lint:
	./gradlew checkstyleMain checkstyleTest

build:
	./gradlew clean build

test:
	./gradlew test

.PHONY: build