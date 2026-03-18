package com.nims_creation.projects.BuildSy.Dto.Project;


public record FileNode(
        String path
) {

    @Override
    public String toString(){
        return path;
    }
}

