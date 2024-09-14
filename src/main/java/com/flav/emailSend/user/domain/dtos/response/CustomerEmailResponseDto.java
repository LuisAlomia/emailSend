package com.flav.emailSend.user.domain.dtos.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerEmailResponseDto {

    private Long id;
    private String emailOwnerId;
    private String clientName;
    private String clientEmail;

}
