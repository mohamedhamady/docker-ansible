package fr.training.metric;

import com.codahale.metrics.Meter;

public class PingMetric extends AbstractMetric {

	private Meter requests;

	@Override
	public void register() {
		this.requests = createMeter("ping-requests");
	}

	public Meter getRequests() {
		return requests;
	}

}
