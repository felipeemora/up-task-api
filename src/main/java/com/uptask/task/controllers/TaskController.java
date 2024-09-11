package com.uptask.task.controllers;

import com.uptask.task.dto.TaskRequestDto;
import com.uptask.task.models.TaskModel;
import com.uptask.task.services.TaskService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/project")
public class TaskController {

  private TaskService taskService;

  @PostMapping("/{id}/tasks")
  public TaskModel create(@PathVariable String id, @Valid @RequestBody TaskRequestDto taskRequestDto) {
    return taskService.create(id, taskRequestDto);
  }

  @GetMapping("/{id}/tasks")
  public List<TaskModel> getTasksByProjectId(@PathVariable String projectId) {
    return taskService.getTasksByProjectId(projectId);
  }
}
