package com.roudaina.babyCare.Mapper;

import com.roudaina.babyCare.DTO.HealthRecord.*;
import com.roudaina.babyCare.entity.HealthRecord;
import org.mapstruct.*;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface HealthRecordMapper {



    HealthRecord toEntity(com.roudaina.babyCare.HeathRecordDTO.HealthRecordRequestDTO dto);

    @Mapping(target = "babyName", source = "baby.name")
    @Mapping(target = "babyId", source = "baby.babyId")
    @Mapping(target = "temperatureStatus", expression = "java(getTemperatureStatus(entity.getTemperature()))")
    @Mapping(target = "heartRateStatus", expression = "java(getHeartRateStatus(entity.getHeartRate()))")
    com.roudaina.babyCare.HeathRecordDTO.HealthRecordResponseDTO toResponseDto(HealthRecord entity);

    default String getTemperatureStatus(BigDecimal temperature) {
        if (temperature == null) return null;
        double temp = temperature.doubleValue();
        if (temp > 37.5) return "High";
        else if (temp < 36.0) return "Low";
        else return "Normal";
    }

    default String getHeartRateStatus(Integer heartRate) {
        if (heartRate == null) return null;
        if (heartRate > 120) return "High";
        else if (heartRate < 80) return "Low";
        else return "Normal";
    }
}
