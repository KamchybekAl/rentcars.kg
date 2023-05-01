package kg.mega.rentcars_kg.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.mega.rentcars_kg.model.enums.*;

import java.time.LocalDate;

public class CarRequestSaveDTO {
    private String photo;
    private String description;
    private Double engineCapacity;
    private Boolean isAvailable;
    private Double fuelConsumption;
   @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate mnfYear;

    private CarModel carModel;

    private CarColor carColor;

    private EngineType engineType;

    private CarTransmission carTransmission;

    private CarCategory carCategory;
    private Double price;
}
