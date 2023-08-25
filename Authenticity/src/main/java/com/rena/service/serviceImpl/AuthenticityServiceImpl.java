package com.rena.service.serviceImpl;

import com.rena.model.Authenticity;
import com.rena.repository.AuthenticityRepository;
import com.rena.service.AuthenticityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthenticityServiceImpl implements AuthenticityService {
    private final AuthenticityRepository authenticityRepository;

    @Override
    public boolean authenticated(Integer customerID){
        authenticityRepository.save(Authenticity.builder()
                        .customerID(customerID)
                        .isAuthenticated(true)
                        .date(LocalDateTime.now())
                .build());
        return true;
    }
}
