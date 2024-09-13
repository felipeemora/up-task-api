package com.uptask.task.dto;

import com.uptask.projects.dto.ProjectResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponseDto {
  private String id;
  private String name;
  private String description;
  private String status;
  private String createdAt;
  private String updatedAt;
  private String projectId;
}
