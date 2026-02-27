package com.nims_creation.projects.BuildSy.Mapper;

import com.nims_creation.projects.BuildSy.Dto.Auth.SignupRequest;
import com.nims_creation.projects.BuildSy.Dto.Auth.UserProfileResponse;
import com.nims_creation.projects.BuildSy.Entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(SignupRequest signupRequest);

    UserProfileResponse toUserProfileResponse(User user);
}
