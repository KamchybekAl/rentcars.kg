package kg.mega.rentcars_kg.service.impl;

import kg.mega.rentcars_kg.mapper.AddressMapper;
import kg.mega.rentcars_kg.model.Address;
import kg.mega.rentcars_kg.model.dto.AddressDTO;
import kg.mega.rentcars_kg.repository.AddressRepo;
import kg.mega.rentcars_kg.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;
    private final AddressMapper addressMapper;
    @Override
    public Address saveAddress(Address address) {
        return addressRepo.save(address); // в return принимать DTO, мапить до жава класса, сохранить жава класс,
        // а потом вернуть обрано сохраненный жава класс в DTO и вернуть фронту.
    }

    public AddressDTO findById(Long id){
        return addressMapper.INSTANCE.toDto(addressRepo.findById(id).get());
    }
}
