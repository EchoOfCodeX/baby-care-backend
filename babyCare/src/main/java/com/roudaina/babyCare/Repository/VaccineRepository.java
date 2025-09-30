package com.roudaina.babyCare.Repository;

import com.roudaina.babyCare.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {

    Optional<Vaccine> findByNameContaining(String name);
    Optional<Vaccine> findByNameIgnoreCase(String name);

    @Query("SELECT v FROM Vaccine v WHERE v.requiredDoses = :doses")
    List<Vaccine> findByRequiredDoses(@Param("doses") Integer doses);

    @Query("SELECT v FROM Vaccine v LEFT JOIN FETCH v.vaccineSchedules WHERE v.id = :id")
    Vaccine findByIdWithSchedules(@Param("id") Long id);






}
