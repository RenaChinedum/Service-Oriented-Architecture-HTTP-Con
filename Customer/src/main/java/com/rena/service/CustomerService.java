package com.rena.service;


import com.rena.entity.dto.rquest.CustomerRegistrationRequest;

public interface CustomerService {
    public String registerUser(CustomerRegistrationRequest request);
}
