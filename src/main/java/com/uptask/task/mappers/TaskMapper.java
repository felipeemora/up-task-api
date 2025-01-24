package com.uptask.task.mappers;

import com.uptask.projects.models.ProjectModel;
import com.uptask.task.dto.TaskRequestDto;
import com.uptask.task.dto.TaskResponseDto;
import com.uptask.task.models.TaskModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {
  TaskMapper MAPPER = Mappers.getMapper(TaskMapper.class);

  default TaskModel toModel(TaskRequestDto requestDto, String projectId) {
    return TaskModel.builder()
        .name(requestDto.getName())
        .description(requestDto.getDescription())
        .project(ProjectModel.builder().id(projectId).build())
        .build();
  }

  default TaskResponseDto toResponseDto(TaskModel taskModel) {
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
}
