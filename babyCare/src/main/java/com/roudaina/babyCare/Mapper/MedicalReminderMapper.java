package com.roudaina.babyCare.Mapper;
import com.roudaina.babyCare.DTO.MedicalReminder.MedicalReminderResponseDTO;
import com.roudaina.babyCare.DTO.MedicalReminder.MedicalReminderUpdateDTO;
import com.roudaina.babyCare.DTO.MedicalReminder.MedicalReminderRequestDTO;
import com.roudaina.babyCare.entity.MedicalReminder;
import org.mapstruct.*;


import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MedicalReminderMapper {

        // RequestDTO -> Entity
        @Mapping(target = "id", ignore = true) // id auto-generated
        @Mapping(target = "baby.id", source = "babyId") // ربط العلاقة مع Baby
        MedicalReminder toEntity(MedicalReminderRequestDTO dto);

        // Entity -> ResponseDTO
        @Mapping(target = "reminderId", source = "id")
        @Mapping(target = "babyId", source = "baby.id")
        @Mapping(target = "babyName", source = "baby.name")
        MedicalReminderResponseDTO toResponseDTO(MedicalReminder entity);

        // Update existing MedicalReminder (ignore null values)
        @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
        void updateMedicalReminderFromDto(MedicalReminderUpdateDTO dto, @MappingTarget MedicalReminder entity);

}
