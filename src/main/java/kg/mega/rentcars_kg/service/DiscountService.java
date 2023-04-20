package kg.mega.rentcars_kg.service;

import kg.mega.rentcars_kg.model.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {
    DiscountDTO saveDiscount (DiscountDTO discountDTO);
    DiscountDTO findById(Long id);
    List<DiscountDTO> findAll();
    DiscountDTO updateDiscount (DiscountDTO discountDTO);

}
