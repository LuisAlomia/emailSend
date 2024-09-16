package com.flav.emailSend.email.persistence.IEmailRepository;

import com.flav.emailSend.email.persistence.Entities.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmailRepository extends JpaRepository<EmailEntity, Long> {

    List<EmailEntity> findAllByEmailOwner(String emailOwner);

}
