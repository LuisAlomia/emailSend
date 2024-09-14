package com.flav.emailSend.user.domain.dtos.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String dateOfBirth;
}
