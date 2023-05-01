package kg.mega.rentcars_kg.service;

import kg.mega.rentcars_kg.model.dto.PriceDTO;

import java.util.List;

public interface PriceService {
    PriceDTO savePrice(PriceDTO priceDTO);
    PriceDTO findById(Long id);
    List<PriceDTO> findAll();
    PriceDTO updatePrice(PriceDTO priceDTO);
    void deletePrice(Long id);
}
