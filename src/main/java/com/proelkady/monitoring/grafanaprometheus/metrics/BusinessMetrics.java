package com.proelkady.monitoring.grafanaprometheus.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.binder.MeterBinder;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class BusinessMetrics implements MeterBinder {
    public Counter webhookSuccess;
    public Counter webhookFail;
    public Timer webhookLatency;

    @Override
    public void bindTo(@NonNull MeterRegistry registry) {
        webhookSuccess = Counter.builder("webhook_api_total").tag("result","success").register(registry);
        webhookFail    = Counter.builder("webhook_api_total").tag("result","fail").register(registry);
        webhookLatency = Timer.builder("webhook_latency_seconds").publishPercentileHistogram(true).register(registry);
    }
}
