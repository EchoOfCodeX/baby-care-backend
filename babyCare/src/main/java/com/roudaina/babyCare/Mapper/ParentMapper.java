package com.roudaina.babyCare.Mapper;


import com.roudaina.babyCare.DTO.Parent.ParentPasswordUpdateDTO;
import com.roudaina.babyCare.DTO.Parent.ParentResponseDTO;
import com.roudaina.babyCare.DTO.Parent.ParentRequestDTO;
import com.roudaina.babyCare.DTO.Parent.ParentUpdateDTO;
//import com.roudaina.babyCare.DTO.Parent.ParentPasswordUpdateDTO;
import com.roudaina.babyCare.entity.Parent;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ParentMapper {
    // Convert ParentRequestDTO -> Parent Entity
    @Mapping(target = "id", ignore = true) // ID auto-generated
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Parent toEntity(ParentRequestDTO dto);

    // Convert Parent Entity -> ParentResponseDTO
    @Mapping(target = "parentId", source = "id")
    ParentResponseDTO toResponseDTO(Parent entity);

    // Update Parent from ParentUpdateDTO
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateParentFromDto(ParentUpdateDTO dto, @MappingTarget Parent entity);

    // Update password from ParentPasswordUpdateDTO
    @Mapping(target = "email", ignore = true)   // ما نبدلوش email
    @Mapping(target = "name", ignore = true)    // ما نبدلوش name
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updatePasswordFromDto(ParentPasswordUpdateDTO dto, @MappingTarget Parent entity);
}