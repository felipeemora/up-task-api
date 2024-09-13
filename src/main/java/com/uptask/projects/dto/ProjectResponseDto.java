package com.uptask.projects.dto;

import com.uptask.task.dto.TaskResponseDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectResponseDto {
  private String id;
  private String projectName;
  private String clientName;
  private String description;
  private List<TaskResponseDto> tasks;
}
