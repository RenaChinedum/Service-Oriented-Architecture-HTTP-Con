package com.rena.controller;


import com.rena.entity.dto.rquest.CustomerRegistrationRequest;
import com.rena.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class CustomerController {

   private final CustomerService customerService;
   @PostMapping("/register")
    public String registerUser(@RequestBody CustomerRegistrationRequest request){
        log.info("new user registration {}", request);
        return customerService.registerUser(request);
    }

}
