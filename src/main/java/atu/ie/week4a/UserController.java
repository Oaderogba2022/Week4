package atu.ie.week4a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private RegistrationServiceClient registrationServiceClient;

    @Autowired
    public UserController(RegistrationServiceClient registrationServiceClient) {
        this.registrationServiceClient = registrationServiceClient;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDetails userDetails) {
        String registrationMessage = "User " + userDetails.getName() + " (" + userDetails.getEmail() + ") has been registered";
        String notificationResult = registrationServiceClient.sendRegistrationNotification(registrationMessage);
        return "Registration successful for" + userDetails.getName() +  "Notification: " + notificationResult;
    }
}
