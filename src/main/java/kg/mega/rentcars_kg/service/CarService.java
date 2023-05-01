package kg.mega.rentcars_kg.service;

import kg.mega.rentcars_kg.model.dto.CarDTO;
import kg.mega.rentcars_kg.model.dto.CarPriceDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarService {

    CarDTO saveCar (CarDTO carDTO);
     ResponseEntity<?> saveCar(CarPriceDTO carPriceDTO);
    CarDTO findById (Long id);
    List<CarDTO> findAll();
    CarDTO updateCar (CarDTO carDTO);
    void deleteCar(Long id);

}
