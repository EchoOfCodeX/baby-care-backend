package com.roudaina.babyCare.repository;

import com.roudaina.babyCare.entity.MedicalReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicalReminderRepository extends JpaRepository<MedicalReminder, Long> {



}
