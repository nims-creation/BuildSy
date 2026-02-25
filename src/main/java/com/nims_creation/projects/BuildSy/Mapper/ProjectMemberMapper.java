package com.nims_creation.projects.BuildSy.Mapper;

import com.nims_creation.projects.BuildSy.Dto.Member.MemberResponse;
import com.nims_creation.projects.BuildSy.Entity.ProjectMember;
import com.nims_creation.projects.BuildSy.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper
@Component("spring")
public interface ProjectMemberMapper {

    @Mapping(target = "userId", source = "id")
    @Mapping(target = "projectRole", constant = "OWNER")
    MemberResponse toProjectMemberResponseFromOwner(User owner);
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
