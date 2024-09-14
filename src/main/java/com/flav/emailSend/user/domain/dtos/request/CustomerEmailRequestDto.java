package com.flav.emailSend.user.domain.dtos.request;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerEmailRequestDto {

    private String emailOwnerId;
    private List<CustomerEmailDto> customerEmails;

}
