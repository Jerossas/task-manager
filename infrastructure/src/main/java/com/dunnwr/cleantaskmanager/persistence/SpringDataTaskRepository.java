package com.dunnwr.cleantaskmanager.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataTaskRepository extends JpaRepository<TaskEntity, Long> {
}
