package fr.training.guice;

import com.google.common.base.Preconditions;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

public class GuiceVertxDeploymentManager {

	private final Vertx vertx;

	public GuiceVertxDeploymentManager(final Vertx vertx) {
		this.vertx = Preconditions.checkNotNull(vertx);
	}

	/**
	 * Deploy a verticle instance given a class of the verticle using default
	 * deployment options and {@link GuiceVerticleFactory} factory.
	 *
	 * @param verticleClazz
	 *            the class of the verticle to deploy.
	 */
	public <T extends AbstractVerticle> void deployVerticle(final Class<T> verticleClazz) {
		Preconditions.checkNotNull(verticleClazz);

		deployVerticle(verticleClazz, new DeploymentOptions());
	}

	/**
	 * Like {@link #deployVerticle(Class)} but
	 * {@link io.vertx.core.DeploymentOptions} are provided to configure the
	 * deployment.
	 *
	 * @param verticleClazz
	 *            the class of the verticle to deploy.
	 * @param options
	 *            the deployment options.
	 */
	public <T extends AbstractVerticle> void deployVerticle(final Class<T> verticleClazz,
			final DeploymentOptions options) {
		Preconditions.checkNotNull(verticleClazz);
		Preconditions.checkNotNull(options);

		this.vertx.deployVerticle(getFullVerticleName(verticleClazz), options);
	}

	/**
	 * Like {@link #deployVerticle(Class, DeploymentOptions)} but handler can be
	 * provided which will be notified when the deployment is complete.
	 *
	 * @param verticleClazz
	 *            the class of the verticle to deploy.
	 * @param options
	 *            the deployment options.
	 * @param completionHandler
	 *            a handler which will be notified when the deployment is
	 *            complete.
	 */
	public void deployVerticle(final Class<AbstractVerticle> verticleClazz, final DeploymentOptions options,
			Handler<AsyncResult<String>> completionHandler) {
		Preconditions.checkNotNull(verticleClazz);
		Preconditions.checkNotNull(options);
		Preconditions.checkNotNull(completionHandler);

		this.vertx.deployVerticle(getFullVerticleName(verticleClazz), options, completionHandler);
	}

	/**
	 * Gets the name of the verticle with adding prefix required to notify vertx
	 * to use
	 * 
	 * @{@link GuiceVerticleFactory} factory for verticle creation.
	 *
	 * @param verticleClazz
	 *            the class of the verticle to deploy.
	 * @return Name of the verticle which can be used for deployment to vertx.
	 */
	private static <T extends AbstractVerticle> String getFullVerticleName(final Class<T> verticleClazz) {
		return GuiceVerticleFactory.PREFIX + ":" + verticleClazz.getCanonicalName();
	}
}
