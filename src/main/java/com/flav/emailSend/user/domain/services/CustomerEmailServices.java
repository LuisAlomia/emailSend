package com.flav.emailSend.user.domain.services;

import com.flav.emailSend.user.domain.dtos.request.CustomerEmailRequestDto;
import com.flav.emailSend.user.domain.dtos.response.CustomerEmailByOwnerResponseDto;
import com.flav.emailSend.user.domain.dtos.response.CustomerEmailResponseDto;
import com.flav.emailSend.user.domain.exception.UserNotFount;
import com.flav.emailSend.user.domain.mappers.CustomerEmailMapper;
import com.flav.emailSend.user.persistence.entities.CustomerEmail;
import com.flav.emailSend.user.persistence.entities.UserEntity;
import com.flav.emailSend.user.persistence.repositories.ICustomerEmailRepository;
import com.flav.emailSend.user.persistence.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerEmailServices implements ICustomerEmailServices{

    private final IUserRepository userRepository;
    private final ICustomerEmailRepository customerEmailRepository;
    private final CustomerEmailMapper customerEmailMapper;

    public CustomerEmailServices(IUserRepository userRepository, ICustomerEmailRepository customerEmailRepository, CustomerEmailMapper customerEmailMapper) {
        this.userRepository = userRepository;
        this.customerEmailRepository = customerEmailRepository;
        this.customerEmailMapper = customerEmailMapper;
    }

    @Override
    public List<CustomerEmailResponseDto> createCustomerEmail(CustomerEmailRequestDto customerEmails) {
        //find user and validate
        findUserByEmail(customerEmails.getEmailOwnerId());

        //from request to entity
        List<CustomerEmail> customerEmail = this.customerEmailMapper.toEntity(customerEmails);

        //save list emails of customers
        List<CustomerEmail> listCustomerEmail = this.customerEmailRepository.saveAll(customerEmail);

        //from Entity to DTO and return
        return customerEmailMapper.toDto(listCustomerEmail);
    }

    @Override
    public CustomerEmailByOwnerResponseDto findAllCustomerEmailByOwner(String emailOwner) {
        //find user
        UserEntity owner = findUserByEmail(emailOwner);

        //find customer email by owner
        List<CustomerEmail> listCustomerEmails = this.customerEmailRepository.findAllByEmailOwnerId(emailOwner);

        //from Entity to DTO and return
        return this.customerEmailMapper.toAllCustomerEmailByOwner(owner, listCustomerEmails);
    }

    private UserEntity findUserByEmail(String emailUser) {
        Optional<UserEntity> user = this.userRepository.findByEmail(emailUser);

        if(user.isEmpty()) throw new UserNotFount();

        return user.get();
    }
}
