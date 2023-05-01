package kg.mega.rentcars_kg.controller;

import kg.mega.rentcars_kg.model.dto.CarDTO;
import kg.mega.rentcars_kg.model.dto.CarPriceDTO;
import kg.mega.rentcars_kg.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping("/save")
    public CarDTO saveCar(@RequestBody CarDTO carDTO){
        return carService.saveCar(carDTO);
    }
    @GetMapping("/findById")
    public CarDTO findById(@RequestParam Long id){
        return carService.findById(id);
    }
    @GetMapping("/findAll")
    public List<CarDTO> findAll(){
        return carService.findAll();
    }
    @PutMapping("/update")
    public CarDTO updateCar (@RequestBody CarDTO carDTO){
        return carService.updateCar(carDTO);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        carService.deleteCar(id);
    }

    @PostMapping("/saveCarWithPrice")
    public ResponseEntity<?> saveCarWithPrice(@RequestBody CarPriceDTO carPriceDTO){
    return carService.saveCar(carPriceDTO);
    }
}







