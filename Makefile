check-updates:
	./gradlew dependencyUpdates

lint:
	./gradlew checkstyleMain checkstyleTest

build:
	./gradlew clean build

.PHONY: build