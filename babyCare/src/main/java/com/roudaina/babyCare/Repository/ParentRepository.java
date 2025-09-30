package com.roudaina.babyCare.Repository;

import com.roudaina.babyCare.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {


    boolean existsByEmail(String email);

    Optional<Parent> findByEmail(String email);
    @Query("SELECT p FROM Parent p WHERE p.name LIKE %:name%")
    List<Parent> findByNameContaining(@Param("name") String name);

    @Query("SELECT p FROM Parent p LEFT JOIN FETCH p.babies WHERE p.id = :id")
    Optional<Parent> findByIdWithBabies(@Param("id") Long id);

}


