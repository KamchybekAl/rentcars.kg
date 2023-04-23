package kg.mega.rentcars_kg.controller;

import kg.mega.rentcars_kg.model.Car;
import kg.mega.rentcars_kg.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping("/save")
    public Car saveCar(@RequestBody Car car){
        return carService.saveCar(car);
    }
    @GetMapping("/findById")
    public Car findById(@RequestParam Long id){
        return carService.findById(id);
    }
    @GetMapping("/findAll")
    public List<Car> findAll(){
        return carService.findAll();
    }
    @PutMapping("/update")
    public Car updateCar (@RequestBody Car car){
        return carService.updateCar(car);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        carService.deleteCar(id);
    }


}
