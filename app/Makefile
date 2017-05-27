# Project vars
PROJECT_NAME ?= vertx-guice
PROJECT_VERSION ?= 1.0.0

# Filenames
DOCKER_COMPOSE_FILE := docker/docker-compose.yml

# Docker project name
PROJECT := $(PROJECT_NAME)-$(PROJECT_VERSION)$(BUILD_ID)

.PHONY: build deploy test

prepare:
	echo "Preparing image"

build:
	echo "Building application ..."
	docker-compose -p $(PROJECT) -f $(DOCKER_COMPOSE_FILE) up build
	echo "Building application done successfully."

deploy:
	echo "Deploying application ..."
	docker-compose  -p $(PROJECT) -f $(DOCKER_COMPOSE_FILE) up build
	echo "Deploying application done successfully."

test:
	echo "Testing application ..."
	docker-compose -p $(PROJECT) -f $(DOCKER_COMPOSE_FILE) up agent
	echo "Testing application done successfully."

clean:
	echo "Cleaning ..."
	docker-compose -p $(PROJECT) -f $(DOCKER_COMPOSE_FILE) down
	echo "Cleaning done."