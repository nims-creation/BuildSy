package com.nims_creation.projects.BuildSy.Service.Impl;

import com.nims_creation.projects.BuildSy.Dto.Auth.AuthResponse;
import com.nims_creation.projects.BuildSy.Dto.Auth.LoginRequest;
import com.nims_creation.projects.BuildSy.Dto.Auth.SignupRequest;
import com.nims_creation.projects.BuildSy.Service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signup(SignupRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
