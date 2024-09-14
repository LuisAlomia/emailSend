package com.flav.emailSend.user.domain.mappers;

import com.flav.emailSend.user.domain.dtos.request.CustomerEmailRequestDto;
import com.flav.emailSend.user.domain.dtos.response.CustomerEmailResponseDto;
import com.flav.emailSend.user.persistence.entities.CustomerEmail;
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

}
