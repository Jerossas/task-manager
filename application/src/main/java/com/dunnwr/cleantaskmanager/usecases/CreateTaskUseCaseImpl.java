package com.dunnwr.cleantaskmanager.usecases;

import com.dunnwr.cleantaskmanager.domain.models.Task;
import com.dunnwr.cleantaskmanager.domain.repositories.TaskRepository;
import com.dunnwr.cleantaskmanager.usecases.commands.CreateTaskCommand;

import java.time.LocalDate;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepository taskRepository;

    public CreateTaskUseCaseImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Task execute(CreateTaskCommand command) {

        Task newTask = new Task(
                command.title(),
                command.description(),
                command.dueDate(),
                LocalDate.now()
        );

        return taskRepository.save(newTask);
    }
}
