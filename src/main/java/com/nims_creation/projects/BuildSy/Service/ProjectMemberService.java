package com.nims_creation.projects.BuildSy.Service;

import com.nims_creation.projects.BuildSy.Dto.Member.InviteMemberRequest;
import com.nims_creation.projects.BuildSy.Dto.Member.MemberResponse;
import com.nims_creation.projects.BuildSy.Dto.Member.UpdateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request);
    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request);
    void removeProjectMember(Long projectId, Long memberId);

}

