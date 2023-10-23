package atu.ie.week4a;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "registration-service", url = " http://localhost:8080")
public interface RegistrationServiceClient {
    @PostMapping("/notify")
    String sendRegistrationNotification(@RequestBody String message);



}
