package com.rena.controller;

import com.rena.dto.response.AuthenticityResponse;
import com.rena.service.AuthenticityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/authenticity")
@RequiredArgsConstructor
public class AuthenticityController {
    private final AuthenticityService authenticityService;

    @GetMapping("/authenticate/{id}")
    public AuthenticityResponse authenticate(@PathVariable("id") Integer customerID){
        boolean authenticated = authenticityService.authenticated(customerID);
       return new AuthenticityResponse(authenticated);
    }
}
