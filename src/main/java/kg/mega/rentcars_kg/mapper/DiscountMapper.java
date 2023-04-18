package kg.mega.rentcars_kg.mapper;

import kg.mega.rentcars_kg.model.Discount;
import kg.mega.rentcars_kg.model.dto.DiscountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiscountMapper {

    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);
    DiscountDTO toDTO(Discount discount);
    Discount toEntity(DiscountDTO discountDTO);

}
