package kg.mega.rentcars_kg.service.impl;

import kg.mega.rentcars_kg.mapper.CarMapper;
import kg.mega.rentcars_kg.mapper.PriceMapper;
import kg.mega.rentcars_kg.model.Car;
import kg.mega.rentcars_kg.model.dto.CarDTO;
import kg.mega.rentcars_kg.model.dto.CarPriceDTO;
import kg.mega.rentcars_kg.repository.CarRepo;
import kg.mega.rentcars_kg.repository.PriceRepo;
import kg.mega.rentcars_kg.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CarServiceImpl implements CarService {
    private final CarRepo carRepo;
    private final CarMapper carMapper;
    private final PriceRepo priceRepo;


    @Override
    public CarDTO saveCar(CarDTO carDTO) {
        Car car = carMapper.toEntity(carDTO);
        Car save = carRepo.save(car);
        return carMapper.toDto(save);
    }

    @Override
    public ResponseEntity<?> saveCar(CarPriceDTO carPriceDTO) {
        Car car = carMapper.toEntity(carPriceDTO.getCarDTO());
        car = carRepo.save(car);
        carPriceDTO.getPriceDTO().setCar(car);
//        Price actualPrice =priceRepo.getActualPrice(car.getId());
//        if (actualPrice!=null){
//            actualPrice.setEndDate(LocalDateTime.now());
//            priceRepo.save(actualPrice);
//        }
        carPriceDTO.getPriceDTO().setStartDate(LocalDateTime.now());
        carPriceDTO.getPriceDTO().setEndDate(carPriceDTO.getPriceDTO().getStartDate().plusYears(100));
        priceRepo.save(PriceMapper.INSTANCE.toEntity(carPriceDTO.getPriceDTO()));
        return ResponseEntity.ok(carPriceDTO);
    }

    @Override
    public CarDTO findById(Long id) {
        return carMapper.toDto(carRepo.findById(id).get());
    }

    @Override
    public List<CarDTO> findAll() {
        return carMapper.toDTOList(carRepo.findAll());
    }

    @Override
    public CarDTO updateCar(CarDTO carDTO) {
        Car updateCar = carRepo.findById(carDTO.getId()).get();
        updateCar.setCarModel(carDTO.getCarModel());
        updateCar.setDescription(carDTO.getDescription());

        return carMapper.toDto(updateCar);
    }

    @Override
    public void deleteCar(Long id) {
        Car deleteCar = carRepo.findById(id).get();
        carRepo.delete(deleteCar);
    }

}
