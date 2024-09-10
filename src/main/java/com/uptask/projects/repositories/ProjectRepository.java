package com.uptask.projects.repositories;

import com.uptask.projects.models.ProjectModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * ProjectRepository.
 */
@Repository
public interface ProjectRepository extends MongoRepository<ProjectModel, String> {
}
