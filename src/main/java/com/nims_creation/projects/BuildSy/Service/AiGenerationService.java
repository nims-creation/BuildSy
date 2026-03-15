package com.nims_creation.projects.BuildSy.Service;

import reactor.core.publisher.Flux;

import java.util.Optional;

public interface AiGenerationService {
    Flux<String> streamResponse(java.lang.String message, Long projectId);
}
