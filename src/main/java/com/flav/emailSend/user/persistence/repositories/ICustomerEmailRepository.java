package com.flav.emailSend.user.persistence.repositories;

import com.flav.emailSend.user.persistence.entities.CustomerEmail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerEmailRepository extends JpaRepository<CustomerEmail, Long> {
    List<CustomerEmail> findAllByEmailOwnerId(String emailOwner);
}
