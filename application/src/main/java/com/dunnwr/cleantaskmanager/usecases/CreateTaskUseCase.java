package com.dunnwr.cleantaskmanager.usecases;

import com.dunnwr.cleantaskmanager.domain.models.Task;
import com.dunnwr.cleantaskmanager.usecases.commands.CreateTaskCommand;

public interface CreateTaskUseCase extends UseCase<CreateTaskCommand, Task>{
}
