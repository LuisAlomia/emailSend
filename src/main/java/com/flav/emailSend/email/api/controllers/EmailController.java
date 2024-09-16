package com.flav.emailSend.email.api.controllers;

import com.flav.emailSend.email.domain.dtos.request.EmailRequestDto;
import com.flav.emailSend.email.domain.dtos.response.AllEmailResponseByOwnerDto;
import com.flav.emailSend.email.domain.dtos.response.EmailResponseDto;
import com.flav.emailSend.email.domain.service.IEmailServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class EmailController {

    private final IEmailServices iEmailServices;

    public EmailController(IEmailServices iEmailServices) {
        this.iEmailServices = iEmailServices;
    }

    @PostMapping("/")
    public ResponseEntity<EmailResponseDto> createEmail(@RequestBody EmailRequestDto email) {
        return ResponseEntity.status(201).body(this.iEmailServices.createEmail(email));
    }

    @GetMapping("/{ownerEmail}")
    public ResponseEntity<AllEmailResponseByOwnerDto> findEmailSendByOwner(@PathVariable  String ownerEmail) {
        return ResponseEntity.status(200).body(this.iEmailServices.findEmailSendByOwner(ownerEmail));
    }

}
