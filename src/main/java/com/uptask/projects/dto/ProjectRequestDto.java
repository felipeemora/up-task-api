package com.uptask.projects.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectRequestDto {
  @NotBlank(message = "Project name is required.")
  private String projectName;

  @NotBlank(message = "Client name is required.")
  private String clientName;

  @NotBlank(message = "Description is required.")
  private String description;

  public void setProjectName(String projectName) {
    this.projectName = projectName.trim();
  }

  public void setClientName(String clientName) {
    this.clientName = clientName.trim();
  }
}
