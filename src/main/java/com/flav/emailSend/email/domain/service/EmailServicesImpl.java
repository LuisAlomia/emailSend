package com.flav.emailSend.email.domain.service;

import com.flav.emailSend.email.domain.dtos.request.EmailRequestDto;
import com.flav.emailSend.email.domain.dtos.response.AllEmailResponseByOwnerDto;
import com.flav.emailSend.email.domain.dtos.response.EmailResponseDto;
import com.flav.emailSend.email.domain.exception.EmailException;
import com.flav.emailSend.email.domain.mappers.EmailMapper;
import com.flav.emailSend.email.persistence.Entities.EmailEntity;
import com.flav.emailSend.email.persistence.IEmailRepository.IEmailRepository;
import com.flav.emailSend.user.domain.dtos.response.CustomerEmailByOwnerResponseDto;
import com.flav.emailSend.user.domain.services.ICustomerEmailServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServicesImpl implements IEmailServices{

    private final IEmailRepository iEmailRepository;
    private final ICustomerEmailServices customerEmailServices;
    private final EmailMapper emailMapper;

    public EmailServicesImpl(IEmailRepository iEmailRepository, ICustomerEmailServices customerEmailServices, EmailMapper emailMapper) {
        this.iEmailRepository = iEmailRepository;
        this.customerEmailServices = customerEmailServices;
        this.emailMapper = emailMapper;
    }

    @Override
    public EmailResponseDto createEmail(EmailRequestDto email) {
        CustomerEmailByOwnerResponseDto ownerAndListCustomer = this.customerEmailServices
                .findAllCustomerEmailByOwner(email.getEmailOwner());

        //if list is empty return error
        if (ownerAndListCustomer.getCustomerEmails().size() < 1) throw new EmailException();

        //from Request DTO to Entity
        EmailEntity newEmail = this.emailMapper.toEntity(ownerAndListCustomer, email.getMessage());

        //Save in database and mapper from Entity to Response DTO
        return this.emailMapper.toDto(this.iEmailRepository.save(newEmail));
    }

    @Override
    public AllEmailResponseByOwnerDto findEmailSendByOwner(String ownerEmail) {
        List<EmailEntity> listMessageByOwner = this.iEmailRepository.findAllByEmailOwner(ownerEmail);

        return this.emailMapper.toAllMessageByOwnerDto(ownerEmail, listMessageByOwner);
    }
}
