package com.uptask.projects.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uptask.task.models.TaskModel;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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

  @DBRef(lazy = true)
  @JsonIgnoreProperties("project")
  private List<TaskModel> tasks;
}
