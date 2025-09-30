package com.roudaina.babyCare.Mapper;
import com.roudaina.babyCare.DTO.VaccineSchedule.VaccineScheduleResponseDTO;
import com.roudaina.babyCare.DTO.VaccineSchedule.VaccineScheduleUpdateDTO;
import com.roudaina.babyCare.DTO.VaccineSchedule.VaccineScheduleRequestDTO;
import com.roudaina.babyCare.entity.VaccineSchedule;
import org.mapstruct.*;

import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface VaccineScheduleMapper {



        // RequestDTO -> Entity
        @Mapping(target = "id", ignore = true)
        @Mapping(target = "baby.id", source = "babyId")
        @Mapping(target = "vaccine.id", source = "vaccineId")
        VaccineSchedule toEntity(VaccineScheduleRequestDTO dto);

        // Entity -> ResponseDTO
        @Mapping(target = "scheduleId", source = "id")
        @Mapping(target = "babyId", source = "baby.id")
        @Mapping(target = "babyName", source = "baby.name")
        @Mapping(target = "vaccineId", source = "vaccine.id")
        @Mapping(target = "vaccineName", source = "vaccine.name")
        VaccineScheduleResponseDTO toResponseDTO(VaccineSchedule entity);

        // UpdateDTO -> update Entity
        @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
        void updateEntityFromDto(VaccineScheduleUpdateDTO dto, @MappingTarget VaccineSchedule entity);

}
