package com.flav.emailSend.email.domain.dtos.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailRequestDto {

    private String emailOwner;
    private String message;

}
