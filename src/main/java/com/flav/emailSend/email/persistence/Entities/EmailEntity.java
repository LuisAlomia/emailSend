package com.flav.emailSend.email.persistence.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "emails")
@Entity
public class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_owner")
    private String nameOwner;
    @Column(name = "email_owner")
    private String emailOwner;
    @Column(name = "string_customer_emails")
    private String stringCustomerEmails;
    private String message;

}
