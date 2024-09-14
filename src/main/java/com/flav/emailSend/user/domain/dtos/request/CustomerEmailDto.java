package com.flav.emailSend.user.domain.dtos.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerEmailDto {

    private String clientName;
    private String clientEmail;

}
