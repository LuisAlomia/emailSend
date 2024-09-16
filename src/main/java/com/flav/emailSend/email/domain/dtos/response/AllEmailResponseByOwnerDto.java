package com.flav.emailSend.email.domain.dtos.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllEmailResponseByOwnerDto {

    private String emailOwner;
    private List<EmailMessageDto> emailMessageDto;

}
