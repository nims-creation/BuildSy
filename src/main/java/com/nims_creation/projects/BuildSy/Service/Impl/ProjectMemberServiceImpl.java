package com.nims_creation.projects.BuildSy.Service.Impl;

import com.nims_creation.projects.BuildSy.Dto.Member.InviteMemberRequest;
import com.nims_creation.projects.BuildSy.Dto.Member.MemberResponse;
import com.nims_creation.projects.BuildSy.Dto.Member.UpdateMemberRoleRequest;
import com.nims_creation.projects.BuildSy.Entity.Project;
import com.nims_creation.projects.BuildSy.Mapper.ProjectMemberMapper;
import com.nims_creation.projects.BuildSy.Repository.ProjectMemberRepository;
import com.nims_creation.projects.BuildSy.Repository.ProjectRepository;
import com.nims_creation.projects.BuildSy.Service.ProjectMemberService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService{

    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectRepository projectRepository;
    private final ProjectMemberMapper projectMemberMapper;


    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);
        List<MemberResponse> memberResponsesList = new ArrayList<>();
        memberResponsesList.add(projectMemberMapper.toProjectMemberResponseFromOwner(project.getOwner()));

        memberResponsesList.addAll(
                projectMemberRepository.findByIdProjectId(projectId)
                        .stream()
                        .map(projectMemberMapper::toProjectMemberResponseFromMember)
                        .toList());


        return memberResponsesList;
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId) {
        return null;
    }

    public Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId, userId).orElseThrow();
    }
}
