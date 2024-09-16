package com.flav.emailSend.email.domain.service;

import com.flav.emailSend.email.domain.dtos.request.EmailRequestDto;
import com.flav.emailSend.email.domain.dtos.response.AllEmailResponseByOwnerDto;
import com.flav.emailSend.email.domain.dtos.response.EmailResponseDto;

public interface IEmailServices {

    public EmailResponseDto createEmail(EmailRequestDto email);
    public AllEmailResponseByOwnerDto findEmailSendByOwner(String ownerEmail);

}
