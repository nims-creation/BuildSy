package com.nims_creation.projects.BuildSy.Dto.Member;

import com.nims_creation.projects.BuildSy.Dto.Chat.ChatResponse;
import com.nims_creation.projects.BuildSy.Entity.ChatMessage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    List<ChatResponse> fromListOfChatMessage(List<ChatMessage> chatMessageList);
}
