package fr.training.metric;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

public abstract class AbstractMetric {

	@Inject
	private MetricRegistry metrics;

	@PostConstruct
	@Inject
	private void init() {
		register();
	}

	/**
	 * register all metrics.
	 */
	public abstract void register();

	protected Histogram createHistogram(String name) {
		return metrics.histogram(MetricRegistry.name(this.getClass(), name));
	}

	protected Counter createCounter(String name) {
		return metrics.counter(MetricRegistry.name(this.getClass(), name));
	}

	protected Timer createTimer(String name) {
		return metrics.timer(MetricRegistry.name(this.getClass(), name));
	}
	protected Meter createMeter(String name) {
		return metrics.meter(MetricRegistry.name(this.getClass(), name));
	}

}
