package com.dunnwr.cleantaskmanager.usecases;

import com.dunnwr.cleantaskmanager.domain.models.Task;
import com.dunnwr.cleantaskmanager.domain.repositories.TaskRepository;
import com.dunnwr.cleantaskmanager.usecases.commands.CreateTaskCommand;

public class CreateTaskUseCase implements UseCase<CreateTaskCommand, Task> {

    private final TaskRepository taskRepository;

    public CreateTaskUseCase(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Task execute(CreateTaskCommand command) {

        Task newTask = new Task(
                command.title(),
                command.description(),
                command.dueDate()
        );

        return taskRepository.save(newTask);
    }
}
