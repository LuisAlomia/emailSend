package com.flav.emailSend.user.domain.mappers;

import com.flav.emailSend.user.domain.dtos.request.CustomerEmailDto;
import com.flav.emailSend.user.domain.dtos.request.CustomerEmailRequestDto;
import com.flav.emailSend.user.domain.dtos.response.CustomerEmailByOwnerResponseDto;
import com.flav.emailSend.user.domain.dtos.response.CustomerEmailResponseDto;
import com.flav.emailSend.user.persistence.entities.CustomerEmail;
import com.flav.emailSend.user.persistence.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerEmailMapper {

    public List<CustomerEmailResponseDto> toDto(List<CustomerEmail> listCustomerEmail) {
        return listCustomerEmail.stream()
                .map(emailCustomers -> {
                    return CustomerEmailResponseDto
                            .builder()
                            .id(emailCustomers.getId())
                            .emailOwnerId(emailCustomers.getEmailOwnerId())
                            .clientName(emailCustomers.getClientName())
                            .clientEmail(emailCustomers.getClientEmail())
                            .build();
                })
                .toList();
    }

    public List<CustomerEmail> toEntity(CustomerEmailRequestDto customerEmails) {
        return customerEmails.getCustomerEmails()
                .stream()
                .map(owner -> {
                    return CustomerEmail
                            .builder()
                            .emailOwnerId(customerEmails.getEmailOwnerId())
                            .clientName(owner.getClientName())
                            .clientEmail(owner.getClientEmail())
                            .build();
                })
                .toList();
    }

    public CustomerEmailByOwnerResponseDto toAllCustomerEmailByOwner(UserEntity owner, List<CustomerEmail> listCustomerEmails) {
        return CustomerEmailByOwnerResponseDto
                .builder()
                .id(owner.getId())
                .nameOwnerId(owner.getName())
                .emailOwnerId(owner.getEmail())
                .customerEmails(listCustomerEmails
                        .stream()
                        .map(emails -> {
                            return CustomerEmailDto
                                    .builder()
                                    .clientName(emails.getClientName())
                                    .clientEmail(emails.getClientEmail())
                                    .build();
                        })
                        .toList())
                .build();
    }

}
