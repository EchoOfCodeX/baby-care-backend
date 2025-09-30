package com.roudaina.babyCare.Mapper;

import com.roudaina.babyCare.DTO.Baby.BabyRequestDTO;
import com.roudaina.babyCare.DTO.Baby.BabyResponseDTO;
import com.roudaina.babyCare.DTO.Baby.BabyUpdateDTO;
import com.roudaina.babyCare.entity.Baby;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface BabyMapper {


    // Convert BabyRequestDTO -> Baby Entity
    @Mapping(target = "id", ignore = true) // ID is auto-generated
    @Mapping(target = "parent.id", source = "parentId")
    // map parentId to parent relation
    Baby toEntity(BabyRequestDTO dto);

    // Convert Baby Entity -> BabyResponseDTO
    @Mapping(target = "babyId", source = "id")
    @Mapping(target = "parentId", source = "parent.id")
    @Mapping(target = "parentName", source = "parent.name")
    @Mapping(target = "email", source = "parent.email")
    BabyResponseDTO toResponseDTO(Baby entity);

    // Update Baby from BabyUpdateDTO
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBabyFromDto(BabyUpdateDTO dto, @MappingTarget Baby entity);
}






