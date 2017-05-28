# Project vars
PROJECT_NAME ?= vertx-guice
PROJECT_VERSION ?= 1.0.0
REPO_NAME ?= vertx-guice

# Filenames
DOCKER_COMPOSE_FILE := docker/docker-compose.yml

# Docker project name
PROJECT := $(PROJECT_NAME)-$(PROJECT_VERSION)$(BUILD_ID)

INSPECT := $$(docker-compose -p $$1 -f $$2 ps -q $$3 | xargs -I ARGS docker inspect -f "{{ .State.ExitCode }}" ARGS)

CHECK := @bash -c '\
  if [[ $(INSPECT) -ne 0 ]]; \
  then exit $(INSPECT); fi' VALUE 

.PHONY: build deploy test

prepare:
	${INFO} "Preparing image"

build:
	${INFO} "Building application ..."
	docker-compose -p $(PROJECT) -f $(DOCKER_COMPOSE_FILE) build build
	docker-compose -p $(PROJECT) -f $(DOCKER_COMPOSE_FILE) up build
	docker cp $$(docker-compose -p $(PROJECT) -f $(DOCKER_COMPOSE_FILE) ps -q build):/opt/app/target/. target
	${CHECK} $(PROJECT) $(DOCKER_COMPOSE_FILE) build
	${INFO} "Building application done successfully."

deploy:
	${INFO} "Deploying application ..."
	docker-compose -p $(PROJECT) -f $(DOCKER_COMPOSE_FILE) build deploy
	docker-compose  -p $(PROJECT) -f $(DOCKER_COMPOSE_FILE) run --rm deploy 
	${INFO} "Deploying application done successfully."

test:
	${INFO} "Testing application ..."
	docker-compose -p $(PROJECT) -f $(DOCKER_COMPOSE_FILE) run --rm agent
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
