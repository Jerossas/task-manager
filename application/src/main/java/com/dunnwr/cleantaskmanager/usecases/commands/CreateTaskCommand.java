package com.dunnwr.cleantaskmanager.usecases.commands;

import java.time.LocalDate;

public record CreateTaskCommand(
        String title,
        String description,
        LocalDate dueDate
) {
}
