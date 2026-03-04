package com.dunnwr.cleantaskmanager.controller;

import com.dunnwr.cleantaskmanager.domain.models.Task;
import com.dunnwr.cleantaskmanager.dto.CreateTaskRequest;
import com.dunnwr.cleantaskmanager.dto.TaskResponse;
import com.dunnwr.cleantaskmanager.usecases.CreateTaskUseCase;
import com.dunnwr.cleantaskmanager.usecases.commands.CreateTaskCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase){
        this.createTaskUseCase = createTaskUseCase;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody CreateTaskRequest request){

        CreateTaskCommand command = new CreateTaskCommand(
                request.title(),
                request.description(),
                request.dueDate()
        );

        Task createdTask = createTaskUseCase.execute(command);

        TaskResponse response = new TaskResponse(
                createdTask.getId(),
                createdTask.getTitle(),
                createdTask.getDescription(),
                createdTask.getStatus().name(),
                createdTask.getDueDate()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
