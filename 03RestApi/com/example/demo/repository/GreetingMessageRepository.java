package com.example.demo.repository;

import com.example.demo.model.GreetingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingMessageRepository extends JpaRepository<GreetingRecord, Long> {
}