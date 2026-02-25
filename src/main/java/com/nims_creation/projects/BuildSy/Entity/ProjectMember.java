package com.nims_creation.projects.BuildSy.Entity;

import com.nims_creation.projects.BuildSy.Entity.Enum.ProjectRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "project_members")
public class ProjectMember {

    @EmbeddedId
    ProjectMemberId id;

    @ManyToMany @MapsId("projectId")
    Project project;

    @ManyToMany @MapsId("userId")
    User user;

    @Enumerated(EnumType.STRING) @Column(nullable = false)
    ProjectRole projectRole;

    Instant invitedAt;
    Instant acceptedAt;
}

