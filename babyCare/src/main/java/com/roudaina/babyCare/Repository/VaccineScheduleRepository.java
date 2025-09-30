package com.roudaina.babyCare.Repository;

import com.roudaina.babyCare.Enum.VaccineStatus;
import com.roudaina.babyCare.entity.VaccineSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface VaccineScheduleRepository extends JpaRepository<VaccineSchedule, Long> {
    Optional<VaccineSchedule> findByBabyId(Long babyId);

    Optional<VaccineSchedule> findByVaccineId(Long vaccineId);

    Optional<VaccineSchedule> findByStatus(VaccineStatus status);

    @Query("SELECT vs FROM VaccineSchedule vs WHERE vs.baby.id = :babyId AND vs.status = :status")
    List<VaccineSchedule> findByBabyIdAndStatus(@Param("babyId") Long babyId,
                                                @Param("status") VaccineStatus status);

    @Query("SELECT vs FROM VaccineSchedule vs WHERE vs.scheduleDate BETWEEN :startDate AND :endDate")
    List<VaccineSchedule> findByScheduleDateBetween(@Param("startDate") LocalDate startDate,
                                                    @Param("endDate") LocalDate endDate);

    @Query("SELECT vs FROM VaccineSchedule vs WHERE vs.scheduleDate <= :date AND vs.status = 'PENDING'")
    List<VaccineSchedule> findOverdueVaccines(@Param("date") LocalDate date);

    @Query("SELECT vs FROM VaccineSchedule vs WHERE vs.baby.parent.id = :parentId")
    List<VaccineSchedule> findByParentId(@Param("parentId") Long parentId);






}
