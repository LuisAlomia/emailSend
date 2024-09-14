package com.flav.emailSend.user.domain.services;

import com.flav.emailSend.user.domain.dtos.request.CustomerEmailRequestDto;
import com.flav.emailSend.user.domain.dtos.response.CustomerEmailByOwnerResponseDto;
import com.flav.emailSend.user.domain.dtos.response.CustomerEmailResponseDto;

import java.util.List;

public interface ICustomerEmailServices {

    public List<CustomerEmailResponseDto> createCustomerEmail(CustomerEmailRequestDto customerEmails);
    public CustomerEmailByOwnerResponseDto findAllCustomerEmailByOwner(String emailOwner);

}
