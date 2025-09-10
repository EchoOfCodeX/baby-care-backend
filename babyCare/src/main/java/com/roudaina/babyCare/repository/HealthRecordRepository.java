package com.roudaina.babyCare.repository;

import com.roudaina.babyCare.entity.HealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HealthRecordRepository extends JpaRepository<HealthRecord, Long> {}
