package com.roudaina.babyCare.Repository;

import com.roudaina.babyCare.entity.HealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Repository
public interface HealthRecordRepository extends JpaRepository<HealthRecord, Long> {
    Optional<HealthRecord> findByBabyId(Long babyId);
    Optional<HealthRecord> findByBabyIdOrderByRecordDateDesc(Long babyId);

    @Query("SELECT hr FROM HealthRecord hr WHERE hr.baby.id = :babyId AND hr.recordDate BETWEEN :startDate AND :endDate ORDER BY hr.recordDate DESC")
    List<HealthRecord> findByBabyIdAndDateRange(@Param("babyId") Long babyId,
                                                @Param("startDate") LocalDateTime startDate,
                                                @Param("endDate") LocalDateTime endDate);

    @Query("SELECT hr FROM HealthRecord hr WHERE hr.temperature > :temperature")
    List<HealthRecord> findByTemperatureGreaterThan(@Param("temperature") Double temperature);

    @Query("SELECT hr FROM HealthRecord hr WHERE hr.heartRate > :heartRate")
    List<HealthRecord> findByHeartRateGreaterThan(@Param("heartRate") Integer heartRate);

    @Query("SELECT hr FROM HealthRecord hr WHERE hr.baby.id = :babyId ORDER BY hr.recordDate DESC LIMIT 1")
    HealthRecord findLatestByBabyId(@Param("babyId") Long babyId);

    @Query("SELECT hr FROM HealthRecord hr WHERE hr.baby.parent.id = :parentId ORDER BY hr.recordDate DESC")
    List<HealthRecord> findByParentId(@Param("parentId") Long parentId);


}
