package kg.mega.rentcars_kg.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.mega.rentcars_kg.model.Address;
import kg.mega.rentcars_kg.model.Car;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDetailDTO {
    private Long id;
    private Boolean babySeat;
    private Boolean withDriver;
    private String clientName;
    private String clientPhone;
    private String clientEmail;
    private Address getAddress;
    private Address returnAddress;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTimeFrom;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTimeTo;
    private Double priceBeforeDiscount;
    private Double priceWithDiscount;
    private Car car;
}
