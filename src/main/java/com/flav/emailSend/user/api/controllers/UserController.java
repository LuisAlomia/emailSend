package com.flav.emailSend.user.api.controllers;

import com.flav.emailSend.user.domain.dtos.request.CustomerEmailRequestDto;
import com.flav.emailSend.user.domain.dtos.request.UserRequestDto;
import com.flav.emailSend.user.domain.dtos.response.CustomerEmailResponseDto;
import com.flav.emailSend.user.domain.dtos.response.UserResponseDto;
import com.flav.emailSend.user.domain.services.ICustomerEmailServices;
import com.flav.emailSend.user.domain.services.IUserServices;
import com.flav.emailSend.user.persistence.entities.CustomerEmail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final IUserServices userServices;
    private final ICustomerEmailServices customerEmailServices;

    public UserController(IUserServices userServices, ICustomerEmailServices customerEmailServices) {
        this.userServices = userServices;
        this.customerEmailServices = customerEmailServices;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") Long userId) {
        return ResponseEntity.status(200).body(this.userServices.getUser(userId));
    }

    @GetMapping("/")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.status(200).body(this.userServices.getAllUsers());
    }

    @PostMapping("/")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto user) {
        return ResponseEntity.status(201).body(this.userServices.createUser(user));
    }

    @PostMapping("/customers/emails")
    public ResponseEntity<List<CustomerEmailResponseDto>> createCustomerEmail(@RequestBody CustomerEmailRequestDto customerEmails) {
        return ResponseEntity.status(201).body(this.customerEmailServices.createCustomerEmail(customerEmails));
    }
}
