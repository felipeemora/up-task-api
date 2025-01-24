package com.uptask.projects.mappers;

import com.uptask.projects.dto.ProjectRequestDto;
import com.uptask.projects.dto.ProjectResponseDto;
import com.uptask.projects.models.ProjectModel;
import com.uptask.task.dto.TaskResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {
  ProjectMapper MAPPER = Mappers.getMapper(ProjectMapper.class);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "tasks", expression = "java(java.util.List.of())")
  ProjectModel toModel(ProjectRequestDto projectRequestDto);

  default ProjectResponseDto toResponseDto(ProjectModel projectModel) {
    return ProjectResponseDto.builder()
        .id(projectModel.getId())
        .projectName(projectModel.getProjectName())
        .clientName(projectModel.getClientName())
        .description(projectModel.getDescription())
        .tasks(projectModel.getTasks().stream()
            .map(taskModel -> TaskResponseDto.builder()
                .id(taskModel.getId())
                .name(taskModel.getName())
                .description(taskModel.getDescription())
                .status(taskModel.getStatus().toString())
                .createdAt(taskModel.getCreatedAt().toString())
                .updatedAt(taskModel.getUpdatedAt().toString())
                .projectId(taskModel.getProject() != null ? taskModel.getProject().getId() : null)
                .build())
            .toList())
        .build();
  }
}
