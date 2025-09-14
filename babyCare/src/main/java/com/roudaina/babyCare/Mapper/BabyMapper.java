package com.roudaina.babyCare.Mapper;
import com.roudaina.babyCare.DTO.Baby.*;
import com.roudaina.babyCare.entity.Baby;
import org.mapstruct.*;

import java.time.LocalDate;
import java.time.Period;

@Mapper(componentModel = "spring")
public interface BabyMapper {



    Baby toEntity(BabyRequestDTO dto);

    @Mapping(target = "ageInYears", expression = "java(getAgeInYears(entity))")
    @Mapping(target = "ageInMonths", expression = "java(getAgeInMonths(entity))")
    @Mapping(target = "ageInDays", expression = "java(getAgeInDays(entity))")
    @Mapping(target = "parentName", source = "parent.name")
    @Mapping(target = "parentId", source = "parent.parentId")
    BabyResponseDTO toResponseDto(Baby entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(BabyUpdateDTO dto, @MappingTarget Baby entity);

    // Custom methods for age
    default int getAgeInYears(Baby entity) {
        return Period.between(entity.getBirthDate(), LocalDate.now()).getYears();
    }

    default int getAgeInMonths(Baby entity) {
        return Period.between(entity.getBirthDate(), LocalDate.now()).getMonths();
    }

    default int getAgeInDays(Baby entity) {
        return Period.between(entity.getBirthDate(), LocalDate.now()).getDays();
    }
}
