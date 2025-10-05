package com.proelkady.monitoring.servicea.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-logger", url = "http://localhost:8081")
public interface ServiceLoggerClient {

    @GetMapping("/something/info")
    ResponseEntity<String> info();
}
