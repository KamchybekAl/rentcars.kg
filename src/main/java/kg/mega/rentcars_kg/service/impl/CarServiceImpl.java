package kg.mega.rentcars_kg.service.impl;

import kg.mega.rentcars_kg.model.Car;
import kg.mega.rentcars_kg.repository.CarRepo;
import kg.mega.rentcars_kg.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepo carRepo;
    @Override
    public Car saveCar(Car car) {
        return carRepo.save(car);
    }
}
