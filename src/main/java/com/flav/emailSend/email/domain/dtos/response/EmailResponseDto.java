package com.flav.emailSend.email.domain.dtos.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailResponseDto {

    private String nameOwner;
    private String emailOwner;
    private String customerEmails;
    private String message;

}
