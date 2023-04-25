package kg.mega.rentcars_kg.service;

import kg.mega.rentcars_kg.model.Car;
import kg.mega.rentcars_kg.model.dto.CarDTO;

import java.util.List;

public interface CarService {

    CarDTO saveCar (CarDTO carDTO);
    CarDTO findById (Long id);
    List<CarDTO> findAll();
    CarDTO updateCar (CarDTO carDTO);
    void deleteCar(Long id);

}
