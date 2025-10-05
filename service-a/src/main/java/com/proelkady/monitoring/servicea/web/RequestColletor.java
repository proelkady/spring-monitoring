package com.proelkady.monitoring.servicea.web;

import com.proelkady.monitoring.servicea.RequestRepository;
import com.proelkady.monitoring.servicea.client.ServiceLoggerClient;
import com.proelkady.monitoring.servicea.model.Request;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/requests")
public class RequestColletor {
    private final RequestRepository requestRepository;
    private final ServiceLoggerClient serviceLoggerClient;

    @PostMapping("/")
    public ResponseEntity<?> createRequest(@RequestBody RequestDTO requestDTO){
        Request request = new Request();
        request.setUuid(requestDTO.getUuid());
        requestRepository.save(request);
        serviceLoggerClient.info();
        return ResponseEntity.ok(request.getId());
    }
}
