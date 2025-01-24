package com.uptask.projects.services.impl;

import com.uptask.exception.ResourceNotFoundException;
import com.uptask.projects.dto.ProjectRequestDto;
import com.uptask.projects.dto.ProjectResponseDto;
import com.uptask.projects.mappers.ProjectMapper;
import com.uptask.projects.models.ProjectModel;
import com.uptask.projects.repositories.ProjectRepository;
import com.uptask.projects.services.ProjectService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

  private final ProjectRepository projectRepository;

  @Override
  public ProjectResponseDto create(ProjectRequestDto projectRequestDto) {
    ProjectModel project = ProjectMapper.MAPPER.toModel(projectRequestDto);
    return ProjectMapper.MAPPER.toResponseDto(project);
  }

  @Override
  public List<ProjectResponseDto> getAll() {
    return toResponseDtoList(projectRepository.findAll());
  }

  @Override
  public ProjectResponseDto getById(String id) {
    return ProjectMapper.MAPPER.toResponseDto(getProjectById(id));
  }

  @Override
  public ProjectResponseDto update(String id, ProjectRequestDto projectRequestDto) {
    ProjectModel project = getProjectById(id);

    project.setProjectName(projectRequestDto.getProjectName());
    project.setClientName(projectRequestDto.getClientName());
    project.setDescription(projectRequestDto.getDescription());

    return ProjectMapper.MAPPER.toResponseDto(projectRepository.save(project));
  }

  @Override
  public void delete(String id) {
    projectRepository.deleteById(id);
  }

  private List<ProjectResponseDto> toResponseDtoList(List<ProjectModel> projectModels) {
    return projectModels.stream().map(ProjectMapper.MAPPER::toResponseDto).toList();
  }

  private ProjectModel getProjectById(String id) {
    return projectRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("project", "id", id));
  }
}
