package com.flav.emailSend.user.domain.services;

import com.flav.emailSend.user.domain.dtos.request.UserRequestDto;
import com.flav.emailSend.user.domain.dtos.response.UserResponseDto;
import com.flav.emailSend.user.domain.exception.UserExist;
import com.flav.emailSend.user.domain.exception.UserNotFount;
import com.flav.emailSend.user.domain.mappers.UserMapper;
import com.flav.emailSend.user.persistence.entities.UserEntity;
import com.flav.emailSend.user.persistence.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplement implements IUserServices {

    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImplement(IUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDto getUser(Long userId) {
        UserEntity user = this.userRepository.findById(userId)
                .orElseThrow(UserNotFount::new);

        return userMapper.toDto(user);
    }

    @Override
    public void getUserByEmail(String userEmail) {
        Optional<UserEntity> user = this.userRepository.findByEmail(userEmail);

        if(user.isPresent()) throw new UserExist();
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return this.userMapper.toListDto(
                this.userRepository.findAll());
    }

    @Override
    public UserResponseDto createUser(UserRequestDto user) {
        //Check if the user exists
        getUserByEmail(user.getEmail());

        UserEntity newUser = this.userRepository.save(this.userMapper.toEntity(user));

        return this.userMapper.toDto(newUser);
    }

    @Override
    public UserResponseDto updateUser(Long userId, UserRequestDto user) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }
}
