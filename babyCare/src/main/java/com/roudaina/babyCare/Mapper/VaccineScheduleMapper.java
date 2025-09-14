package com.roudaina.babyCare.Mapper;

import com.roudaina.babyCare.DTO.VaccineSchedule.*;
import com.roudaina.babyCare.entity.VaccineSchedule;
import org.mapstruct.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Mapper(componentModel = "spring")
public interface VaccineScheduleMapper {


    @Mapping(target = "status", constant = "SCHEDULED")
    VaccineSchedule toEntity(VaccineScheduleRequestDTO dto);

    @Mapping(target = "babyName", source = "baby.name")
    @Mapping(target = "babyId", source = "baby.babyId")
    @Mapping(target = "vaccineName", source = "vaccine.vaccineName")
    @Mapping(target = "vaccineId", source = "vaccine.vaccineId")
    @Mapping(target = "daysOverdue", expression = "java(getDaysOverdue(entity))")
    VaccineScheduleResponseDTO toResponseDto(VaccineSchedule entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(VaccineScheduleUpdateDTO dto, @MappingTarget VaccineSchedule entity);

    default Integer getDaysOverdue(VaccineSchedule entity) {
        if (entity.getStatus() == VaccineSchedule.VaccineStatus.SCHEDULED &&
                entity.getScheduledDate().isBefore(LocalDate.now())) {
            return (int) ChronoUnit.DAYS.between(entity.getScheduledDate(), LocalDate.now());
        }
        return null;
    }


}
