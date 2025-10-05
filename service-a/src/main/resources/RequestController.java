package com.proelkady.monitoring.servicea.web;

import com.proelkady.monitoring.servicea.RequestRepository;
import com.proelkady.monitoring.servicea.client.ServiceLoggerClient;
import com.proelkady.monitoring.servicea.model.Request;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.Date;

@RequiredArgsConstructor
@RestController("api/v1/requests")
public class RequestController {

    private final RequestRepository requestRepository;
    private final ServiceLoggerClient serviceLoggerClient;

    @PostMapping("/")
    public Request createRequest(@RequestBody RequestDTO requestDTO) {
        Request request = new Request();
        request.setUuid(requestDTO.getUuid());
        request.setCreatedAt(new Date());
        Request save = requestRepository.save(request);
        serviceLoggerClient.info();
        return save;
    }
}
