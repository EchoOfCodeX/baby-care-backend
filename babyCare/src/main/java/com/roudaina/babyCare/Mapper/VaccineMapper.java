package com.roudaina.babyCare.Mapper;
import com.roudaina.babyCare.DTO.Vaccine.VaccineRequestDTO;
import com.roudaina.babyCare.DTO.Vaccine.VaccineResponseDTO;
import com.roudaina.babyCare.DTO.Vaccine.VaccineUpdateDTO;
import com.roudaina.babyCare.entity.Vaccine;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface VaccineMapper {

        // Convert VaccineRequestDTO -> Vaccine Entity
        @Mapping(target = "id", ignore = true)  // auto-generated
        @Mapping(target = "name",source = "vaccineName")
        Vaccine toEntity(VaccineRequestDTO dto);

        // Convert Vaccine Entity -> VaccineResponseDTO
        @Mapping(target = "vaccineId", source = "id")
        @Mapping(target = "vaccineName",source = "name")
        VaccineResponseDTO toResponseDTO(Vaccine entity);

        // Update Vaccine from VaccineUpdateDTO (only non-null values)
        @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
        void updateVaccineFromDto(VaccineUpdateDTO dto, @MappingTarget Vaccine entity);

}
