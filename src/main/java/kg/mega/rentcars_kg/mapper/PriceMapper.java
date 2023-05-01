package kg.mega.rentcars_kg.mapper;

import kg.mega.rentcars_kg.model.Price;
import kg.mega.rentcars_kg.model.dto.PriceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface PriceMapper {
    PriceMapper  INSTANCE = Mappers.getMapper(PriceMapper.class);

    PriceDTO toDto(Price Price);
    Price toEntity(PriceDTO priceDTO);
    List<PriceDTO> toDTOList(List<Price>priceList);
    List<Price> toEntityList(List<PriceDTO>priceDTOList);

}
