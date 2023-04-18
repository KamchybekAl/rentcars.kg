package kg.mega.rentcars_kg.service;

import kg.mega.rentcars_kg.model.Address;
import kg.mega.rentcars_kg.model.dto.AddressDTO;

public interface AddressService {
    Address saveAddress (Address address);
    AddressDTO findById(Long id);

}
