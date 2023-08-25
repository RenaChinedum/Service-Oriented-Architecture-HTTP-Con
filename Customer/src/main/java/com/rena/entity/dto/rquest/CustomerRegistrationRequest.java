package com.rena.entity.dto.rquest;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRegistrationRequest {
    private String fullName;
    private String email;
}
