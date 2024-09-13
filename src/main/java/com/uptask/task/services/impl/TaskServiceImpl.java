package com.uptask.task.services.impl;

import com.uptask.models.ValidationResultModel;
import com.uptask.projects.models.ProjectModel;
import com.uptask.projects.repositories.ProjectRepository;
import com.uptask.task.dto.TaskRequestDto;
import com.uptask.task.dto.TaskResponseDto;
import com.uptask.task.models.TaskModel;
import com.uptask.task.repositories.TaskRepository;
import com.uptask.task.services.TaskService;
import com.uptask.task.utils.TaskStatus;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

  private TaskRepository taskRepository;
  private ProjectRepository projectRepository;

  @Override
  public TaskResponseDto create(String projectId, TaskRequestDto requestDto) {
    ProjectModel project = projectRepository.findById(projectId)
        .orElseThrow(() -> new RuntimeException("Project not found"));
    TaskModel taskCreated = taskRepository.save(toModel(requestDto, project.getId()));

    project.getTasks().add(taskCreated);
    projectRepository.save(project);
    return toResponseDto(taskCreated);
  }

  @Override
  public List<TaskResponseDto> getTasksByProjectId(String projectId) {
    return taskRepository.findByProjectId(projectId).stream().map(this::toResponseDto).toList();
  }

  @Override
  public TaskResponseDto getTasksById(String projectId, String taskId) {
    ValidationResultModel validationResult = validateData(projectId, taskId);

    return toResponseDto(validationResult.getTask());
  }

  @Override
  public void update(String projectId, String taskId, TaskRequestDto requestDto) {
    ValidationResultModel validationResult = validateData(projectId, taskId);

    validationResult.getTask().setName(requestDto.getName());
    validationResult.getTask().setDescription(requestDto.getDescription());

    taskRepository.save(validationResult.getTask());
  }

  @Override
  public void delete(String projectId, String taskId) {
    validateData(projectId, taskId);
    taskRepository.deleteById(taskId);
  }

  @Override
  public void updateStatus(String projectId, String taskId, TaskStatus status) {
    ValidationResultModel validationResult = validateData(projectId, taskId);

    validationResult.getTask().setStatus(status);
    taskRepository.save(validationResult.getTask());
  }

  private TaskModel toModel(TaskRequestDto requestDto, String projectId) {
    return TaskModel.builder()
        .name(requestDto.getName())
        .description(requestDto.getDescription())
        .project(ProjectModel.builder().id(projectId).build())
        .build();
  }

  private TaskResponseDto toResponseDto(TaskModel taskModel) {
    String status = taskModel.getStatus() != null ? taskModel.getStatus().toString() : null;
    return TaskResponseDto.builder()
        .id(taskModel.getId())
        .name(taskModel.getName())
        .description(taskModel.getDescription())
        .status(status)
        .projectId(taskModel.getProject().getId())
        .createdAt(taskModel.getCreatedAt().toString())
        .updatedAt(taskModel.getUpdatedAt().toString())
        .build();
  }

  private ValidationResultModel validateData(String projectId, String taskId) {
    ProjectModel project = projectRepository.findById(projectId)
        .orElseThrow(() -> new RuntimeException("Project not found"));

    TaskModel task = taskRepository.findById(taskId)
        .orElseThrow(() -> new RuntimeException("Task not found"));

    if (!Objects.equals(task.getProject().getId(), projectId)) {
      throw new RuntimeException("Action not valid");
    }

    return ValidationResultModel.builder()
        .project(project)
        .task(task)
        .build();
  }
}
