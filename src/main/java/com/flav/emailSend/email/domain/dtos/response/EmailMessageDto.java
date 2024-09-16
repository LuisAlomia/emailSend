package com.flav.emailSend.email.domain.dtos.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailMessageDto {

    private String customerEmails;
    private String message;

}
