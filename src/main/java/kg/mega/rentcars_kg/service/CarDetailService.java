package kg.mega.rentcars_kg.service;

import kg.mega.rentcars_kg.model.CarDetail;
import kg.mega.rentcars_kg.model.dto.CarDetailDTO;

import java.util.List;

public interface CarDetailService {
    CarDetailDTO saveCarDetail (CarDetailDTO carDetailDTO);
    CarDetailDTO findById (Long id);
    List<CarDetailDTO>findAll();
    CarDetailDTO updateCarDetail(CarDetailDTO carDetailDTO);
    List<CarDetail> findAllActive();
    CarDetail findReservedDays(CarDetail carDetail);

}
