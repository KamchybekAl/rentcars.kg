package kg.mega.rentcars_kg.mapper;

import kg.mega.rentcars_kg.model.Address;
import kg.mega.rentcars_kg.model.dto.AddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    AddressDTO toDto(Address address);
    Address toEntity(AddressDTO addressDTO);

}
