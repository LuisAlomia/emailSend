package com.flav.emailSend.user.persistence.repositories;

import com.flav.emailSend.user.persistence.entities.CustomerEmail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerEmailRepository extends JpaRepository<CustomerEmail, Long> {
}
