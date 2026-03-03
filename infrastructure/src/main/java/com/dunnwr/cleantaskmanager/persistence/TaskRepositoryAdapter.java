package com.dunnwr.cleantaskmanager.persistence;

import com.dunnwr.cleantaskmanager.domain.models.Status;
import com.dunnwr.cleantaskmanager.domain.models.Task;
import com.dunnwr.cleantaskmanager.domain.repositories.TaskRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepositoryAdapter implements TaskRepository {

    private final SpringDataTaskRepository taskRepository;

    public TaskRepositoryAdapter(SpringDataTaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Task save(Task task) {

        TaskEntity newTaskEntity = new TaskEntity(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus().name(),
                task.getDueDate()
        );

        TaskEntity savedEntity = taskRepository.save(newTaskEntity);

        return Task.restore(
                savedEntity.getId(),
                savedEntity.getTitle(),
                savedEntity.getDescription(),
                Status.valueOf(savedEntity.getStatus()),
                savedEntity.getDueDate()
        );
    }
}
