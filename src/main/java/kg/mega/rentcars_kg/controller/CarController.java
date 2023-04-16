package kg.mega.rentcars_kg.controller;

import kg.mega.rentcars_kg.model.Car;
import kg.mega.rentcars_kg.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @PostMapping("/save")
    public Car saveCar(@RequestBody Car car){
        return carService.saveCar(car);
    }
}
