package com.rena.service;


import com.rena.dto.response.AuthenticityResponse;
import com.rena.entity.Customer;
import com.rena.entity.dto.rquest.CustomerRegistrationRequest;
import com.rena.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    @Override
    public String registerUser(CustomerRegistrationRequest request) {
        Customer user = Customer.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .build();
        customerRepository.saveAndFlush(user);
        AuthenticityResponse authenticityResponse =
        restTemplate.getForObject("http://localhost:8084/api/v1/authenticity/authenticate/{id}",
                AuthenticityResponse.class, user.getId());
       if (!authenticityResponse.isAuthenticated()){
           return "Not Authenticated";
       }
        return "You're Registered as " + request.getFullName() + "  with email: " + request.getEmail();
    }
}
