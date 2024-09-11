package com.uptask.task.repositories;

import com.uptask.task.models.TaskModel;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<TaskModel, String> {
  List<TaskModel> findByProjectId(String projectId);
}
