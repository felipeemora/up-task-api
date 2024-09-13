package com.uptask.models;

import com.uptask.projects.models.ProjectModel;
import com.uptask.task.models.TaskModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidationResultModel {
  ProjectModel project;
  TaskModel task;
}
