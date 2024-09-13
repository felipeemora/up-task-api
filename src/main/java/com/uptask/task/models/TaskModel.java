package com.uptask.task.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uptask.projects.models.ProjectModel;
import com.uptask.task.utils.TaskStatus;
import java.time.Instant;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "tasks")
public class TaskModel {

  @Id
  private String id;

  private String name;

  private String description;

  @DBRef(lazy = true)
  @JsonIgnoreProperties("tasks")
  private ProjectModel project;

  @Builder.Default
  private TaskStatus status = TaskStatus.PENDING;

  @CreatedDate
  private Instant createdAt;

  @LastModifiedDate
  private Instant updatedAt;
}
