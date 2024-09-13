package com.uptask.projects.services.impl;

import com.uptask.projects.dto.ProjectRequestDto;
import com.uptask.projects.dto.ProjectResponseDto;
import com.uptask.projects.models.ProjectModel;
import com.uptask.projects.repositories.ProjectRepository;
import com.uptask.projects.services.ProjectService;
import com.uptask.task.dto.TaskResponseDto;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {
  private static final String PROJECT_NOT_FOUND = "Project not found";

  private final ProjectRepository projectRepository;

  @Override
  public ProjectResponseDto create(ProjectRequestDto projectRequestDto) {
    return toResponseDto(projectRepository.save(toModel(projectRequestDto)));
  }

  @Override
  public List<ProjectResponseDto> getAll() {
    return toResponseDtoList(projectRepository.findAll());
  }

  @Override
  public ProjectResponseDto getById(String id) {
    return toResponseDto(
        projectRepository.findById(id).orElseThrow(() -> new RuntimeException(PROJECT_NOT_FOUND))
    );
  }

  @Override
  public ProjectResponseDto update(String id, ProjectRequestDto projectRequestDto) {
    ProjectModel project = projectRepository.findById(id).orElseThrow(() -> new RuntimeException(PROJECT_NOT_FOUND));
    project.setProjectName(projectRequestDto.getProjectName());
    project.setClientName(projectRequestDto.getClientName());
    project.setDescription(projectRequestDto.getDescription());

    return toResponseDto(projectRepository.save(project));
  }

  @Override
  public void delete(String id) {
    projectRepository.deleteById(id);
  }

  private ProjectModel toModel(ProjectRequestDto projectRequestDto) {
    return ProjectModel.builder()
        .projectName(projectRequestDto.getProjectName())
        .clientName(projectRequestDto.getClientName())
        .description(projectRequestDto.getDescription())
        .tasks(List.of())
        .build();
  }

  private ProjectResponseDto toResponseDto(ProjectModel projectModel) {
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
                .projectId(taskModel.getProject().getId())
                .build())
            .toList())
        .build();
  }

  private List<ProjectResponseDto> toResponseDtoList(List<ProjectModel> projectModels) {
    return projectModels.stream().map(this::toResponseDto).toList();
  }
}
