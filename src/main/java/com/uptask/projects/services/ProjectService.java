package com.uptask.projects.services;

import com.uptask.projects.dto.ProjectRequestDto;
import com.uptask.projects.dto.ProjectResponseDto;
import java.util.List;

/**
 * ProjectService.
 */
public interface ProjectService {
  ProjectResponseDto create(ProjectRequestDto projectRequestDto);

  List<ProjectResponseDto> getAll();

  ProjectResponseDto getById(String id);

  ProjectResponseDto update(String id, ProjectRequestDto projectRequestDto);

  void delete(String id);
}
