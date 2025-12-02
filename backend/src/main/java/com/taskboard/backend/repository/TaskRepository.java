package com.taskboard.backend.repository;

import com.taskboard.backend.model.Task;
import com.taskboard.backend.model.enums.Priority;
import com.taskboard.backend.model.enums.Status;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {

    List<Task> findByStatus(Status status);

    List<Task> findByPriority(Priority priority);

    List<Task> findByProjectId(String projectId);

    List<Task> findByAssigneeId(String assigneeId);

    List<Task> findByLabelsContaining(String label);

    List<Task> findByStatusAndProjectId(Status status, String projectId);
}