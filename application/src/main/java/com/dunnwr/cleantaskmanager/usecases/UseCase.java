package com.dunnwr.cleantaskmanager.usecases;

public interface UseCase<I, O> {
    O execute(I input);
}
