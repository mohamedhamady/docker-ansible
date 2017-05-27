package fr.training.handler;

import javax.inject.Inject;

import fr.training.metric.PingMetric;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public class PingHandler implements Handler<RoutingContext>{
	
	@Inject
	private PingMetric pingMetric;
	
	@Override
	public void handle(RoutingContext context) {
		pingMetric.getRequests().mark();
		context.response().end("Pong");
	}

}
