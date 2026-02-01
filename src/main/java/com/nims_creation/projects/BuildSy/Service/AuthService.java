package com.nims_creation.projects.BuildSy.Service;

import com.nims_creation.projects.BuildSy.Dto.Auth.AuthResponse;
import com.nims_creation.projects.BuildSy.Dto.Auth.LoginRequest;
import com.nims_creation.projects.BuildSy.Dto.Auth.SignupRequest;

public interface AuthService{
    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);

}
