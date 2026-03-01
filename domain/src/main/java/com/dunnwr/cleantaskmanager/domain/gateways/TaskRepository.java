package com.dunnwr.cleantaskmanager.domain.gateways;

import com.dunnwr.cleantaskmanager.domain.Task;

public interface TaskRepository {

    Task save(Task task);
}
