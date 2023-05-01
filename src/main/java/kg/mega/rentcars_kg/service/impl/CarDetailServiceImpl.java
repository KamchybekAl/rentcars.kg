package kg.mega.rentcars_kg.service.impl;

import kg.mega.rentcars_kg.mapper.CarDetailMapper;
import kg.mega.rentcars_kg.model.CarDetail;
import kg.mega.rentcars_kg.model.dto.CarDetailDTO;
import kg.mega.rentcars_kg.repository.CarDetailRepo;
import kg.mega.rentcars_kg.service.CarDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Transactional

public class CarDetailServiceImpl implements CarDetailService {
    private final CarDetailRepo carDetailRepo;
    private final CarDetailMapper carDetailMapper;

    @Override
    public CarDetailDTO saveCarDetail(CarDetailDTO carDetailDTO) {
        CarDetail carDetail = carDetailMapper.toEntity(carDetailDTO);
        CarDetail save = carDetailRepo.save(carDetail);
        return carDetailMapper.toDto(save);
    }

    @Override
    public CarDetailDTO findById(Long id) {
        return carDetailMapper.toDto(carDetailRepo.findById(id).get());
    }

    @Override
    public List<CarDetailDTO> findAll() {
        return carDetailMapper.toDTOList(carDetailRepo.findAll());
    }

    @Override
    public CarDetailDTO updateCarDetail(CarDetailDTO carDetailDTO) {
        CarDetail updateCarDetail = carDetailRepo.findById(carDetailDTO.getId()).get();
        updateCarDetail.setDateTimeFrom(carDetailDTO.getDateTimeFrom());
        updateCarDetail.setDateTimeTo(carDetailDTO.getDateTimeTo());
        return carDetailMapper.toDto(updateCarDetail);
    }

    @Override
    public List<CarDetail> findAllActive() {
        List<CarDetail> carTempList = carDetailRepo.findAll();
        List<CarDetail> toArrayList = new ArrayList<>();
        for (int i = 0; i < carTempList.size(); i++) {
            toArrayList.add(findReservedDays(carTempList.get(i)));
        }
        return toArrayList;
    }

    @Override
    public CarDetail findReservedDays(CarDetail carDetail) {
        carDetail = carDetailRepo.findById(carDetail.getCar().getId()).get();
        if (carDetail != null) {
            Instant instant1 = carDetail.getDateTimeFrom().toInstant(ZoneOffset.UTC);
            Long millis1 = instant1.toEpochMilli();
            Instant instant2 = carDetail.getDateTimeTo().toInstant(ZoneOffset.UTC);
            Long millis2 = instant2.toEpochMilli();
            Long diffInMillses = Math.abs(millis1 - millis2);
            Long diffInDays = TimeUnit.DAYS.convert(diffInMillses, TimeUnit.MILLISECONDS);

            List<LocalDate> reservedDays = new ArrayList<>();
            for (int i = 0; i < diffInDays; i++) {
                LocalDate startDay = carDetail.getDateTimeFrom().toLocalDate().plusDays(i);
                reservedDays.add(startDay);
            }
            carDetail.setReservedDates(reservedDays);
        }
        return carDetailRepo.save(carDetail);
    }
}