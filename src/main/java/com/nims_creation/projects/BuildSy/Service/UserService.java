package com.nims_creation.projects.BuildSy.Service;

import com.nims_creation.projects.BuildSy.Dto.Auth.UserProfileResponse;

public interface UserService {
    UserProfileResponse getProfile(Long userId);
}
