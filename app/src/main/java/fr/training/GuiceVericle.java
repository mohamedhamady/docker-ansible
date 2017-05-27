package fr.training;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.training.handler.PingHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;

public class GuiceVericle extends AbstractVerticle {

	private static final Logger LOGGER = LoggerFactory.getLogger(GuiceVericle.class);

	@Inject
	private PingHandler pingHandler;

	@Override
	public void start(Future<Void> future) {

		Router router = Router.router(vertx);
		router.route("/ping").handler(pingHandler);

		vertx.createHttpServer().requestHandler(router::accept).listen(8080, result -> {
			if (result.succeeded()) {
				LOGGER.debug("Request is handled successfully");
				future.complete();
			} else {
				LOGGER.error("An error occured while handling current request", result.cause());
				future.fail(result.cause());
			}
		});
	}

}
