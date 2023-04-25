package kg.mega.rentcars_kg.service.impl;

import kg.mega.rentcars_kg.mapper.CarMapper;
import kg.mega.rentcars_kg.model.Car;
import kg.mega.rentcars_kg.model.dto.CarDTO;
import kg.mega.rentcars_kg.repository.CarRepo;
import kg.mega.rentcars_kg.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CarServiceImpl implements CarService {
    private final CarRepo carRepo;
    private final CarMapper carMapper;

    @Override
    public CarDTO saveCar(CarDTO carDTO) {

        Car car = carMapper.toEntity(carDTO);
        Car save = carRepo.save(car);
        return carMapper.toDto(save);
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
