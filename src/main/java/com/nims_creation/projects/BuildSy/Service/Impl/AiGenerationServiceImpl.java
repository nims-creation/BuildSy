package com.nims_creation.projects.BuildSy.Service.Impl;

import com.nims_creation.projects.BuildSy.Service.AiGenerationService;
import reactor.core.publisher.Flux;

public class AiGenerationServiceImpl implements AiGenerationService {

    @Override
    public Flux<String> streamResponse(String message, Long projectId) {
        return null;
    }
}
