package fr.training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

import fr.training.guice.GuiceVerticleFactory;
import fr.training.guice.GuiceVertxBinder;
import fr.training.guice.GuiceVertxDeploymentManager;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;

public class MainVerticle extends AbstractVerticle {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainVerticle.class);

	@Override
	public void start() {

		Injector injector = Guice.createInjector(new GuiceVertxBinder(vertx));
		GuiceVerticleFactory guiceVerticleFactory = new GuiceVerticleFactory(injector);
		vertx.registerVerticleFactory(guiceVerticleFactory);

		LOGGER.debug("Deploy {}", GuiceVericle.class);
		GuiceVertxDeploymentManager deploymentManager = new GuiceVertxDeploymentManager(this.vertx);
		deploymentManager.deployVerticle(GuiceVericle.class, new DeploymentOptions().setWorker(true));

	}

}