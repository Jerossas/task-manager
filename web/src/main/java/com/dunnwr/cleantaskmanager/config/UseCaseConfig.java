package com.dunnwr.cleantaskmanager.config;

import com.dunnwr.cleantaskmanager.domain.repositories.TaskRepository;
import com.dunnwr.cleantaskmanager.usecases.CreateTaskUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CreateTaskUseCase createTaskUseCase(TaskRepository taskRepositoryAdapter){
        return new CreateTaskUseCase(taskRepositoryAdapter);
    }
}
