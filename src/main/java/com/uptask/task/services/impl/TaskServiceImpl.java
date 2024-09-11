package com.uptask.task.services.impl;

import com.uptask.projects.models.ProjectModel;
import com.uptask.projects.repositories.ProjectRepository;
import com.uptask.task.dto.TaskRequestDto;
import com.uptask.task.models.TaskModel;
import com.uptask.task.repositories.TaskRepository;
import com.uptask.task.services.TaskService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

  private TaskRepository taskRepository;
  private ProjectRepository projectRepository;

  @Override
  public TaskModel create(String projectId, TaskRequestDto requestDto) {
    ProjectModel project = projectRepository.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));
    TaskModel taskCreated = taskRepository.save(toModel(requestDto, project));
    project.getTasks().add(taskCreated);
    projectRepository.save(project);

    return taskCreated;
  }

  @Override
  public List<TaskModel> getTasksByProjectId(String projectId) {
    return taskRepository.findByProjectId(projectId);
  }

  private TaskModel toModel(TaskRequestDto requestDto, ProjectModel projectModel) {
    return TaskModel.builder()
        .name(requestDto.getName())
        .description(requestDto.getDescription())
        .project(projectModel)
        .build();
  }
}
