package com.uptask.task.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDto {

  @NotBlank(message = "Task name is required.")
  private String name;

  @NotBlank(message = "Task description is required.")
  private String description;
}
