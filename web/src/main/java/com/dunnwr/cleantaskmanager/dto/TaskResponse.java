package com.dunnwr.cleantaskmanager.dto;

import java.time.LocalDate;

public record TaskResponse(
        Long id,
        String title,
        String description,
        String status,
        LocalDate dueDate
) {
}
