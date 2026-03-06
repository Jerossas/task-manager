package com.dunnwr.cleantaskmanager.domain;

import com.dunnwr.cleantaskmanager.domain.models.Status;
import com.dunnwr.cleantaskmanager.domain.models.Task;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {

    @Test
    void shouldCreateAPendingTaskWhenPassingValidArguments(){

        Task newTask = new Task(
                "Get a job",
                "I need to get a job as soon as possible. This shit is awful",
                LocalDate.of(2026, Month.JUNE, 1),
                LocalDate.now()
        );

        assertEquals(Status.PENDING, newTask.getStatus());
    }
}
