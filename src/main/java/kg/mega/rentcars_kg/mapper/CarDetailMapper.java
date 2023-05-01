package kg.mega.rentcars_kg.mapper;

import kg.mega.rentcars_kg.model.CarDetail;
import kg.mega.rentcars_kg.model.dto.CarDetailDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CarDetailMapper {
    CarDetailDTO toDto(CarDetail carDetail);
    CarDetail toEntity(CarDetailDTO carDetailDTO);

    List<CarDetailDTO> toDTOList(List<CarDetail>carDetailList);
    List<CarDetail>toEntity(List<CarDetailDTO>carDetailDTOList);
}
