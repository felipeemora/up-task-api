package com.uptask.task.controllers;

import com.uptask.task.dto.TaskRequestDto;
import com.uptask.task.dto.TaskResponseDto;
import com.uptask.task.services.TaskService;
import com.uptask.task.utils.TaskStatus;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/project")
public class TaskController {

  private TaskService taskService;

  @PostMapping("/{id}/tasks")
  public TaskResponseDto create(@PathVariable String id, @Valid @RequestBody TaskRequestDto taskRequestDto) {
    return taskService.create(id, taskRequestDto);
  }

  @GetMapping("/{id}/tasks")
  public List<TaskResponseDto> getTasksByProjectId(@PathVariable String id) {
    return taskService.getTasksByProjectId(id);
  }

  @GetMapping("/{projectId}/tasks/{taskId}")
  public TaskResponseDto getTaskById(@PathVariable String projectId, @PathVariable String taskId) {
    return taskService.getTasksById(projectId, taskId);
  }

  @PutMapping("/{projectId}/tasks/{taskId}")
  public void update(@Valid @RequestBody TaskRequestDto taskRequestDto,
                                @PathVariable String projectId, @PathVariable String taskId) {
    taskService.update(projectId, taskId, taskRequestDto);
  }

  @DeleteMapping("/{projectId}/tasks/{taskId}")
  public void delete(@PathVariable String projectId, @PathVariable String taskId) {
    taskService.delete(projectId, taskId);
  }

  @PatchMapping("/{projectId}/tasks/{taskId}")
  public void updateStatus(@PathVariable String projectId, @PathVariable String taskId, @RequestParam String status) {
    taskService.updateStatus(projectId, taskId, TaskStatus.fromKey(status));
  }
}
