package com.roudaina.babyCare.Repository;

import com.roudaina.babyCare.Enum.RecurrencePattern;
import com.roudaina.babyCare.entity.MedicalReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Repository
public interface MedicalReminderRepository extends JpaRepository<MedicalReminder, Long> {

    Optional<MedicalReminder> findByBabyId(Long babyId);

    Optional<MedicalReminder> findByIsRecurring(Boolean isRecurring);

    Optional<MedicalReminder> findByRecurrencePattern(RecurrencePattern pattern);

    @Query("SELECT mr FROM MedicalReminder mr WHERE mr.reminderDate BETWEEN :startDate AND :endDate ORDER BY mr.reminderDate ASC")
    List<MedicalReminder> findByReminderDateBetween(@Param("startDate") LocalDateTime startDate,
                                                    @Param("endDate") LocalDateTime endDate);

    @Query("SELECT mr FROM MedicalReminder mr WHERE mr.reminderDate <= :date ORDER BY mr.reminderDate ASC")
    List<MedicalReminder> findDueReminders(@Param("date") LocalDateTime date);

    @Query("SELECT mr FROM MedicalReminder mr WHERE mr.baby.parent.id = :parentId ORDER BY mr.reminderDate ASC")
    List<MedicalReminder> findByParentId(@Param("parentId") Long parentId);

    @Query("SELECT mr FROM MedicalReminder mr WHERE mr.baby.id = :babyId AND mr.reminderDate >= :fromDate ORDER BY mr.reminderDate ASC")
    List<MedicalReminder> findUpcomingRemindersByBabyId(@Param("babyId") Long babyId,
                                                        @Param("fromDate") LocalDateTime fromDate);

}
