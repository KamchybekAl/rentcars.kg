package kg.mega.rentcars_kg.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import kg.mega.rentcars_kg.model.enums.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private CarModel carModel;
    private String photo;
    private String description;
    @JsonFormat(pattern = "yyyy")
    private LocalDate mnfYear;
    @Enumerated(value = EnumType.STRING)
    private CarColor carColor;
    private Double engineCapacity;
    @Enumerated(value = EnumType.STRING)
    private EngineType engineType;
    @Enumerated(value = EnumType.STRING)
    private CarTransmission carTransmission;
    private Double fuelConsumption;
    @Enumerated(value = EnumType.STRING)
    private CarCategory carCategory;
    private Boolean isAvailable;
    private BigDecimal price; //(OneToMany)


}
