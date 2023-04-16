package kg.mega.rentcars_kg.controller;

import kg.mega.rentcars_kg.model.Address;
import kg.mega.rentcars_kg.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    @PostMapping("/save")
    public Address saveAddress(@RequestBody Address address){
        return addressService.saveAddress(address);

    }

}
