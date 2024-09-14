package com.flav.emailSend.user.domain.mappers;

import com.flav.emailSend.user.domain.dtos.request.UserRequestDto;
import com.flav.emailSend.user.domain.dtos.response.UserResponseDto;
import com.flav.emailSend.user.persistence.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    public UserResponseDto toDto(UserEntity user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .dateOfBirth(user.getDateOfBirth())
                .build();
    }

    public List<UserResponseDto> toListDto(List<UserEntity> users) {
        return users
                .stream()
                .map(user -> {
                    return UserResponseDto.builder()
                            .id(user.getId())
                            .name(user.getName())
                            .lastName(user.getLastName())
                            .email(user.getEmail())
                            .dateOfBirth(user.getDateOfBirth())
                            .build();
                })
                .toList();
    }

    public UserEntity toEntity(UserRequestDto user) {
        return UserEntity.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .dateOfBirth(user.getDateOfBirth())
                .build();
    }

}
