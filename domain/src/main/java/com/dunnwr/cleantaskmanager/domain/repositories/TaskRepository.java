package com.dunnwr.cleantaskmanager.domain.repositories;

import com.dunnwr.cleantaskmanager.domain.models.Task;

public interface TaskRepository {

    Task save(Task task);
}
