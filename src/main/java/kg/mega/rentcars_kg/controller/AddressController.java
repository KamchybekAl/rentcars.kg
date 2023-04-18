package kg.mega.rentcars_kg.controller;

import kg.mega.rentcars_kg.model.Address;
import kg.mega.rentcars_kg.model.dto.AddressDTO;
import kg.mega.rentcars_kg.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    @PostMapping("/save")
    public Address saveAddress(@RequestBody Address address){
        return addressService.saveAddress(address);
    }
    @GetMapping("/findbyid")
    public AddressDTO findById (@RequestParam Long id){
        return addressService.findById(id);
    }

}
