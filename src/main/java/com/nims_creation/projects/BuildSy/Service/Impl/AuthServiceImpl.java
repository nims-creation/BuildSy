package com.nims_creation.projects.BuildSy.Service.Impl;

import com.nims_creation.projects.BuildSy.Dto.Auth.AuthResponse;
import com.nims_creation.projects.BuildSy.Dto.Auth.LoginRequest;
import com.nims_creation.projects.BuildSy.Dto.Auth.SignupRequest;
import com.nims_creation.projects.BuildSy.Entity.User;
import com.nims_creation.projects.BuildSy.Error.BadRequestException;
import com.nims_creation.projects.BuildSy.Mapper.UserMapper;
import com.nims_creation.projects.BuildSy.Repository.UserRepository;
import com.nims_creation.projects.BuildSy.Service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse signup(SignupRequest request) {
        userRepository.findByUsername(request.username()).ifPresent(user->{
            throw new BadRequestException("user already exists with username:" + request.username());
        });

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user = userRepository.save(user);
        return new AuthResponse("dummy", userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
