package com.roudaina.babyCare.Mapper;


import com.roudaina.babyCare.DTO.MedicalReminder.*;
import com.roudaina.babyCare.entity.MedicalReminder;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Mapper(componentModel = "spring")

public interface MedicalReminderMapper {


    @Mapping(target = "status", constant = "ACTIVE")
    MedicalReminder toEntity(MedicalReminderRequestDTO dto);

    @Mapping(target = "babyName", source = "baby.name")
    @Mapping(target = "babyId", source = "baby.babyId")
    @Mapping(target = "hoursUntilReminder", expression = "java(getHoursUntilReminder(entity))")
    MedicalReminderResponseDTO toResponseDto(MedicalReminder entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(MedicalReminderUpdateDTO dto, @MappingTarget MedicalReminder entity);

    default Integer getHoursUntilReminder(MedicalReminder entity) {
        if (entity.getReminderDate() != null && entity.getReminderDate().isAfter(LocalDateTime.now())) {
            return (int) ChronoUnit.HOURS.between(LocalDateTime.now(), entity.getReminderDate());
        }
        return null;
    }
}
