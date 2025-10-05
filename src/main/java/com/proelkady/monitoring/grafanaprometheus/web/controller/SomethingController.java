package com.proelkady.monitoring.grafanaprometheus.web.controller;

import com.proelkady.monitoring.grafanaprometheus.metrics.BusinessMetrics;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Log4j2
@RestController
public class SomethingController {
    private final BusinessMetrics metrics;

    @GetMapping("/something/info")
    public String getSomething() {
        var start = System.nanoTime();
        boolean success = false;
        try {
            log.info("Doing something");
            success = true;
        } catch (Exception e) {
            log.error("Doing something error", e);
        } finally {
            metrics.webhookFail.increment();
            metrics.webhookLatency.record(System.nanoTime() - start, TimeUnit.NANOSECONDS);
            (success ? metrics.webhookSuccess : metrics.webhookFail).increment();
        }
        return "something";
    }

    @GetMapping("/something/error")
    public String getSomethingError() {
        var start = System.nanoTime();
        boolean success = false;
        try {
            log.error("Doing error something");
        } catch (Exception e) {
            log.error("Doing something error", e);
        } finally {
            metrics.webhookFail.increment();
            metrics.webhookLatency.record(System.nanoTime() - start, TimeUnit.NANOSECONDS);
            (success ? metrics.webhookSuccess : metrics.webhookFail).increment();
        }
        return "something error";
    }
}
