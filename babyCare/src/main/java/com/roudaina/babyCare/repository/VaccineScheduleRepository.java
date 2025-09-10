package com.roudaina.babyCare.repository;

import com.roudaina.babyCare.entity.VaccineSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VaccineScheduleRepository extends JpaRepository<VaccineSchedule, Long> {}
