package com.dunnwr.cleantaskmanager.domain;

import java.time.LocalDate;

public class Task {

    private Long id;
    private String title;
    private String description;
    private Status status;
    private LocalDate dueDate;

    public Task(String title, String description, LocalDate dueDate){
        changeTitle(title);
        changeDescription(description);
        changeDueDate(dueDate);
        this.status = Status.PENDING;
    }

    public void setId(Long id){

        if(id <= 0){
            throw new IllegalArgumentException("Id cannot be negative or zero");
        }

        this.id = id;
    }

    public Long getId(){
        return this.id;
    }

    public void changeTitle(String title){

        if (title == null){
            throw new IllegalArgumentException("The title cannot be null.");
        }

        if (title.isBlank()){
            throw new IllegalArgumentException("The title cannot be empty.");
        }

        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void changeDescription(String description){

        if (description == null){
            throw new IllegalArgumentException("The description cannot be null.");
        }

        if (description.isBlank()){
            throw new IllegalArgumentException("The description cannot be empty.");
        }

        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public void markTaskAsCompleted(){

        if(this.status == Status.COMPLETED){
            throw new IllegalArgumentException("The task is already completed.");
        }

        this.status = Status.COMPLETED;
    }

    public Status getStatus(){
        return this.status;
    }

    public void changeDueDate(LocalDate newDueDate){

        if(newDueDate == null){
            throw new IllegalArgumentException("The due date cannot be null.");
        }

        if(newDueDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("The expiration date cannot be earlier than the current date.");
        }

        this.dueDate = newDueDate;
    }

    public LocalDate getDueDate(){
        return this.dueDate;
    }

}
