package com.uptask.task.services;

import com.uptask.task.dto.TaskRequestDto;
import com.uptask.task.dto.TaskResponseDto;
import com.uptask.task.utils.TaskStatus;
import java.util.List;

public interface TaskService {
  TaskResponseDto create(String projectId, TaskRequestDto requestDto);
  List<TaskResponseDto> getTasksByProjectId(String projectId);
  TaskResponseDto getTasksById(String projectId, String taskId);
  void update(String projectId, String taskId, TaskRequestDto taskRequestDto);
  void delete(String projectId, String taskId);
  void updateStatus(String projectId, String taskId, TaskStatus status);
}
