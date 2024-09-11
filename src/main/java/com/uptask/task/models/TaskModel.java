package com.uptask.task.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

  @DBRef
  @JsonManagedReference
  private ProjectModel project;

  private TaskStatus status = TaskStatus.PENDING;

  @CreatedDate
  private Instant createdAt;

  @LastModifiedDate
  private Instant updatedAt;
}
