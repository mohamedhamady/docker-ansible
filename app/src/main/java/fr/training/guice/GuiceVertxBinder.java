package fr.training.guice;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.SharedMetricRegistries;
import com.google.inject.AbstractModule;

import fr.training.handler.PingHandler;
import fr.training.metric.PingMetric;
import io.vertx.core.Vertx;

/**
 * Guice {@link AbstractModule} for vertx and container injections
 */
public class GuiceVertxBinder extends AbstractModule {

	private final Vertx vertx;

	public GuiceVertxBinder(Vertx vertx) {
		this.vertx = vertx;
	}

	@Override
	protected void configure() {
		bind(Vertx.class).toInstance(vertx);
		bind(PingHandler.class).toInstance(new PingHandler());
		bind(MetricRegistry.class).toInstance(SharedMetricRegistries.getOrCreate("vertx-metric-registry"));
		bind(PingMetric.class).toInstance(new PingMetric());
	}
}
