package kg.mega.rentcars_kg.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CarPriceDTO {
    private CarDTO carDTO;
    private PriceDTO priceDTO;
}
