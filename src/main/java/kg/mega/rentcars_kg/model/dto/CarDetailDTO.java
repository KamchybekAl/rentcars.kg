package kg.mega.rentcars_kg.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.mega.rentcars_kg.model.Car;
import lombok.Data;

import javax.persistence.ElementCollection;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CarDetailDTO {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTimeFrom;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTimeTo;
    @ElementCollection
    private List<LocalDateTime> reservedDates;
    private Car car;
}
