package kg.mega.rentcars_kg.controller;

import kg.mega.rentcars_kg.model.CarDetail;
import kg.mega.rentcars_kg.model.dto.CarDetailDTO;
import kg.mega.rentcars_kg.service.CarDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cardetail")
@RequiredArgsConstructor
public class CarDetailController {
    private final CarDetailService carDetailService;
    @PostMapping("/save")
    public CarDetailDTO saveCarDetail(@RequestBody CarDetailDTO carDetailDTO){
        return carDetailService.saveCarDetail(carDetailDTO);
    }
    @GetMapping("/findById")
    public CarDetailDTO findById (@RequestParam Long id){
        return carDetailService.findById(id);
    }
    @GetMapping("/findAll")
    public List<CarDetailDTO> findAll(){
        return carDetailService.findAll();
    }
    @PostMapping("/update")
    public CarDetailDTO updateCarDetail (@RequestBody CarDetailDTO carDetailDTO){
        return carDetailService.updateCarDetail(carDetailDTO);
    }
    @PostMapping("/findeserveddays")
    public CarDetail findReservedDays (@RequestBody CarDetail carDetail){
        return carDetailService.findReservedDays(carDetail);
    }
    @GetMapping("/findAllActive")
    public List<CarDetail> findAllActive(){
        return carDetailService.findAllActive();
    }


}
