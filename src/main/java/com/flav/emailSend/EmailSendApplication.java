package com.flav.emailSend;

import com.flav.emailSend.user.persistence.entities.UserEntity;
import com.flav.emailSend.user.persistence.repositories.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EmailSendApplication implements CommandLineRunner {

	private final IUserRepository userRepository;

	public EmailSendApplication(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(EmailSendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserEntity user1 = new UserEntity(1L,"luis","alomia","alomia21","alomia@gamil.com","21-05-1994");
		UserEntity user2 = new UserEntity(2L,"diego","alom","diego21","diego@gamil.com","21-05-1994");
		UserEntity user3 = new UserEntity(3L,"andres","val","andres21","andres@gamil.com","21-05-1994");

		var users = List.of(user1, user2, user3);

		userRepository.saveAll(users);

	}
}
