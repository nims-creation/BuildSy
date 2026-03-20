package com.nims_creation.projects.BuildSy.Repository;

import com.nims_creation.projects.BuildSy.Entity.ChatEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatEventRepository extends JpaRepository<ChatEvent, Long> {
}
