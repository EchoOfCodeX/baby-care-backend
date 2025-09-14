package com.roudaina.babyCare.Mapper;
import com.roudaina.babyCare.DTO.Vaccine.*;
import com.roudaina.babyCare.entity.Vaccine;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VaccineMapper {
    Vaccine toEntity(VaccineRequestDTO dto);
    VaccineResponseDTO toResponseDto(Vaccine entity);

}
