package com.nims_creation.projects.BuildSy.Repository;

import com.nims_creation.projects.BuildSy.Entity.ChatSession;
import com.nims_creation.projects.BuildSy.Entity.ChatSessionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatSessionRepository extends JpaRepository<ChatSession, ChatSessionId> {
}
