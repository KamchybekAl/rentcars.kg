package kg.mega.rentcars_kg.mapper;

import kg.mega.rentcars_kg.model.Car;
import kg.mega.rentcars_kg.model.dto.CarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    CarDTO toDto(Car car);
    Car toEntity(CarDTO carDTO);
    List<CarDTO> toDTOList(List<Car>carList);
    List<Car> toEntityList(List<CarDTO>carDTOList);

}
