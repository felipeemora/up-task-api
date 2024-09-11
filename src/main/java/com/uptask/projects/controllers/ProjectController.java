package com.uptask.projects.controllers;

import com.uptask.projects.dto.ProjectRequestDto;
import com.uptask.projects.dto.ProjectResponseDto;
import com.uptask.projects.services.ProjectService;
import com.uptask.utils.ValidObjectIdUtils;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/project")
public class ProjectController {

  private final ProjectService projectService;

  @PostMapping
  ProjectResponseDto create(@Valid @RequestBody ProjectRequestDto projectRequestDto) {
    return projectService.create(projectRequestDto);
  }

  @GetMapping
  List<ProjectResponseDto> getAll() {
    return projectService.getAll();
  }

  @GetMapping("/{id}")
  ProjectResponseDto getById(@PathVariable @ValidObjectIdUtils String id) {
    return projectService.getById(id);
  }

  @PutMapping("/{id}")
  ProjectResponseDto update(@Valid @RequestBody ProjectRequestDto projectRequestDto,
                            @PathVariable @ValidObjectIdUtils String id) {
    return projectService.update(id, projectRequestDto);
  }

  @DeleteMapping("/{id}")
  void delete(@PathVariable @ValidObjectIdUtils String id) {
    projectService.delete(id);
  }
}
