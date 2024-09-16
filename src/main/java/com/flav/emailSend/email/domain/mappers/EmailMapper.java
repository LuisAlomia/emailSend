package com.flav.emailSend.email.domain.mappers;

import com.flav.emailSend.email.domain.dtos.response.AllEmailResponseByOwnerDto;
import com.flav.emailSend.email.domain.dtos.response.EmailMessageDto;
import com.flav.emailSend.email.domain.dtos.response.EmailResponseDto;
import com.flav.emailSend.email.persistence.Entities.EmailEntity;
import com.flav.emailSend.user.domain.dtos.request.CustomerEmailDto;
import com.flav.emailSend.user.domain.dtos.response.CustomerEmailByOwnerResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailMapper {

    public EmailEntity toEntity(CustomerEmailByOwnerResponseDto ownerAndListCustomer, String messageEmail) {
        //Get list of customers emails
        List<String> listEmails = ownerAndListCustomer
                .getCustomerEmails()
                .stream()
                .map(CustomerEmailDto::getClientEmail)
                .toList();

        //from Request DTO to Entity
        return EmailEntity.builder()
                .nameOwner(ownerAndListCustomer.getNameOwnerId())
                .emailOwner(ownerAndListCustomer.getEmailOwnerId())
                .stringCustomerEmails(String.join(", ", listEmails))
                .message(messageEmail)
                .build();
    }

    public EmailResponseDto toDto(EmailEntity email) {
        return EmailResponseDto.builder()
                .nameOwner(email.getNameOwner())
                .emailOwner(email.getEmailOwner())
                .customerEmails(email.getStringCustomerEmails())
                .message(email.getMessage())
                .build();
    }

    public AllEmailResponseByOwnerDto toAllMessageByOwnerDto(String ownerEmail, List<EmailEntity> listMessageByOwner) {
        return AllEmailResponseByOwnerDto
                .builder()
                .emailOwner(ownerEmail)
                .emailMessageDto(listMessageByOwner
                        .stream()
                        .map(email -> {
                            return EmailMessageDto
                                    .builder()
                                    .customerEmails(email.getStringCustomerEmails())
                                    .message(email.getMessage())
                                    .build();
                        }).toList()
                )
                .build();
    }
}
