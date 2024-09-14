package com.flav.emailSend.user.domain.services;

import com.flav.emailSend.user.domain.dtos.request.UserRequestDto;
import com.flav.emailSend.user.domain.dtos.response.UserResponseDto;

import java.util.List;

public interface IUserServices {
    UserResponseDto getUser(Long userId);
    void getUserByEmail(String userEmail);
    List<UserResponseDto> getAllUsers();
    UserResponseDto createUser(UserRequestDto user);
    UserResponseDto updateUser(Long userId, UserRequestDto user);
    void deleteUser(Long userId);
}
