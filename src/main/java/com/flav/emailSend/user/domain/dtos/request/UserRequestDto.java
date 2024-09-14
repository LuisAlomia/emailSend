package com.flav.emailSend.user.domain.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {
    @NotBlank
    @NotEmpty(message = "is required")
    private String name;

    @NotBlank
    @NotEmpty(message = "is required")
    private String lastName;

    @NotBlank
    @NotEmpty(message = "is required")
    private String password;

    @NotBlank
    @NotEmpty(message = "is required")
    private String email;

    @NotBlank
    @NotEmpty(message = "is required")
    private String dateOfBirth;
}
