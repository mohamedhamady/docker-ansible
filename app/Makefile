# Project vars
PROJECT_NAME ?= vertx-guice
PROJECT_VERSION ?= 1.0.0
REPO_NAME ?= vertx-guice

# Filenames
DOCKER_COMPOSE_FILE := docker/docker-compose.yml

# Docker project name
PROJECT := $(PROJECT_NAME)-$(PROJECT_VERSION)$(BUILD_ID)

.PHONY: build deploy test

prepare:
	${INFO} "Preparing image"

build:
	${INFO} "Building application ..."
	docker-compose -p $(PROJECT) -f $(DOCKER_COMPOSE_FILE) up build
	${INFO} "Building application done successfully."

deploy:
	${INFO} "Deploying application ..."
	docker-compose  -p $(PROJECT) -f $(DOCKER_COMPOSE_FILE) up build
	${INFO} "Deploying application done successfully."

test:
	${INFO} "Testing application ..."
	docker-compose -p $(PROJECT) -f $(DOCKER_COMPOSE_FILE) up agent
	${INFO} "Testing application done successfully."

clean:
	${INFO} "Cleaning ..."
	docker-compose -p $(PROJECT) -f $(DOCKER_COMPOSE_FILE) down
	docker images -q  -f dangling=true | xargs -I ARGS docker rmi -f ARGS
	docker volume ls -q -f dangling=true | xargs -I ARGS docker volume rm ARGS
	${INFO} "Cleaning done."
# docker images -q  -f dangling=true -f label=application=$(REPO_NAME)| xargs -I ARGS docker rmi -f ARGS

# Costmetics
YELLOW := "\e[1;33m"
NC := "\e[0M"

INFO := @bash -c '\
  printf $(YELLOW); \
  echo "=> $$1"; \
  printf $(NC)' VALUE
