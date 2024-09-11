package com.uptask.task.services;

import com.uptask.task.dto.TaskRequestDto;
import com.uptask.task.models.TaskModel;
import java.util.List;

public interface TaskService {
  TaskModel create(String projectId, TaskRequestDto requestDto);
  List<TaskModel> getTasksByProjectId(String projectId);
}
