package com.flav.emailSend.user.domain.dtos.response;

import com.flav.emailSend.user.domain.dtos.request.CustomerEmailDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerEmailByOwnerResponseDto {

    private Long id;
    private String nameOwnerId;
    private String emailOwnerId;
    private List<CustomerEmailDto> customerEmails;

}
