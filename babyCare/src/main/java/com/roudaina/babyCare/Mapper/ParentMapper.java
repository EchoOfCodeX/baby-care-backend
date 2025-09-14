package com.roudaina.babyCare.Mapper;



import com.roudaina.babyCare.DTO.Parent.*;
import com.roudaina.babyCare.entity.Parent;
import org.mapstruct.*;

@Mapper(componentModel = "spring")

public interface ParentMapper {

    Parent toEntity(ParentRequestDTO dto);

    ParentResponseDTO toResponseDto(Parent entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(ParentUpdateDTO dto, @MappingTarget Parent entity);
}
