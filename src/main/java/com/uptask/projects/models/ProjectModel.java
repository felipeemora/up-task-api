package com.uptask.projects.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "project")
public class ProjectModel {
  @Id
  private String id;
  private String projectName;
  private String clientName;
  private String description;
}
