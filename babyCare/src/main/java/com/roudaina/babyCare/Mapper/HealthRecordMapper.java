package com.roudaina.babyCare.Mapper;

import com.roudaina.babyCare.entity.HealthRecord;
import org.mapstruct.Mapper;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface HealthRecordMapper {

    // RequestDTO -> Entity
    @Mapping(target = "id", ignore = true) // auto-generated
    @Mapping(target = "baby.id", source = "babyId") // نربط babyId من DTO بالـ relation
    HealthRecord toEntity(com.roudaina.babyCare.HeathRecordDTO.HealthRecordRequestDTO dto);

    // Entity -> ResponseDTO
    @Mapping(target = "recordId", source = "id")
    @Mapping(target = "babyId", source = "baby.id")
    @Mapping(target = "babyName", source = "baby.name") // نرجع اسم البيبي في الـ response
    com.roudaina.babyCare.HeathRecordDTO.HealthRecordResponseDTO toResponseDTO(HealthRecord entity);

    // Update Entity from UpdateDTO (ignore nulls)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateHealthRecordFromDto(com.roudaina.babyCare.HeathRecordDTO.HealthRecordUpdateDTO dto, @MappingTarget HealthRecord entity);




}
