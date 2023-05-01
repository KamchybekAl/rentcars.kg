package kg.mega.rentcars_kg.service.impl;

import kg.mega.rentcars_kg.mapper.PriceMapper;
import kg.mega.rentcars_kg.model.Price;
import kg.mega.rentcars_kg.model.dto.PriceDTO;
import kg.mega.rentcars_kg.repository.CarRepo;
import kg.mega.rentcars_kg.repository.PriceRepo;
import kg.mega.rentcars_kg.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PriceServiceImpl implements PriceService {
    private final PriceRepo priceRepo;
    private final PriceMapper priceMapper;
    private final CarRepo carRepo;



    @Override
    public PriceDTO savePrice(PriceDTO priceDTO) {
        Price price = priceMapper.toEntity(priceDTO);
        price.setStartDate(LocalDateTime.now());
        price.setEndDate(price.getStartDate().plusYears(100));
//        Price actualPrice =priceRepo.getActualPrice(priceDTO.getCar().getId());
//        if (actualPrice!=null){
//            actualPrice.setEndDate(LocalDateTime.now());
//            priceRepo.save(actualPrice);
//        }
        price.setCar(carRepo.findById(priceDTO.getCar().getId()).get());
        Price save = priceRepo.save(price);
        return priceMapper.toDto(save);
    }
    @Override
    public PriceDTO findById(Long id)  {
        return priceMapper.toDto(priceRepo.findById(id).get());
    }
    @Override
    public List<PriceDTO> findAll() {
        return priceMapper.toDTOList(priceRepo.findAll());
    }

    @Override
    public PriceDTO updatePrice(PriceDTO priceDTO) {
        Price price = priceMapper.toEntity(priceDTO);
        Price updatePrice = priceRepo.findById(priceDTO.getId()).get();
        updatePrice.setPrice(priceDTO.getPrice());
        updatePrice.setStartDate(priceDTO.getStartDate());
        updatePrice.setEndDate(priceDTO.getEndDate());
//        updatePrice.setStartDate(LocalDateTime.now());
//        updatePrice.setEndDate(price.getStartDate().plusYears(200));
        return priceMapper.toDto(updatePrice);
    }

    @Override
    public void deletePrice(Long id) {
        Price deletePrice = priceRepo.findById(id).get();
        priceRepo.delete(deletePrice);

    }
}
