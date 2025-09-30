package com.roudaina.babyCare.Repository;


import com.roudaina.babyCare.Enum.Gender;
import com.roudaina.babyCare.entity.Baby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BabyRepository extends JpaRepository<Baby, Long> {


    Optional<Baby> findByParentId(Long parentId);


    Optional<Baby> findByGender(Gender gender);

    @Query("SELECT b FROM Baby b WHERE b.birthDate BETWEEN :startDate AND :endDate")
    List<Baby> findByBirthDateBetween(@Param("startDate") LocalDate startDate,
                                      @Param("endDate") LocalDate endDate);

    @Query("SELECT b FROM Baby b WHERE b.parent.id = :parentId AND b.name LIKE %:name%")
    List<Baby> findByParentIdAndNameContaining(@Param("parentId") Long parentId,
                                               @Param("name") String name);

    @Query("SELECT b FROM Baby b LEFT JOIN FETCH b.healthRecords WHERE b.id = :id")
    Optional<Baby> findByIdWithHealthRecords(@Param("id") Long id);

    @Query("SELECT b FROM Baby b LEFT JOIN FETCH b.vaccineSchedules WHERE b.id = :id")
    Optional<Baby> findByIdWithVaccineSchedules(@Param("id") Long id);

    @Query("SELECT b FROM Baby b WHERE b.currentTemperature > :temperature")
    List<Baby> findByCurrentTemperatureGreaterThan(@Param("temperature") Double temperature);}
