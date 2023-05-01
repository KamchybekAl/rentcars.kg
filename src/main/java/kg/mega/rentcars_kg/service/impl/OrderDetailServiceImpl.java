package kg.mega.rentcars_kg.service.impl;

import kg.mega.rentcars_kg.mapper.OrderDetailMapper;
import kg.mega.rentcars_kg.model.OrderDetail;
import kg.mega.rentcars_kg.model.dto.OrderDetailDTO;
import kg.mega.rentcars_kg.repository.AddressRepo;
import kg.mega.rentcars_kg.repository.CarRepo;
import kg.mega.rentcars_kg.repository.OrderDetailRepo;
import kg.mega.rentcars_kg.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepo orderDetailRepo;
    private final OrderDetailMapper orderDetailMapper;
    private final CarRepo carRepo;
    private final AddressRepo addressRepo;
    @Override
    public OrderDetailDTO saveOrderDetail(OrderDetailDTO orderDetailDTO) {
        OrderDetail orderDetail = orderDetailMapper.toEntity(orderDetailDTO);
        orderDetail.setCar(carRepo.findById(orderDetailDTO.getCar().getId()).get());
        orderDetail.setGetAddress(addressRepo.findById(orderDetailDTO.getGetAddress().getId()).get());
        orderDetail.setReturnAddress(addressRepo.findById(orderDetailDTO.getReturnAddress().getId()).get());

        OrderDetail save = orderDetailRepo.save(orderDetail);
        return orderDetailMapper.toDto(save);
    }
    @Override
    public OrderDetailDTO findById(Long id) {
        return orderDetailMapper.toDto(orderDetailRepo.findById(id).get());
    }

    @Override
    public List<OrderDetailDTO> findAll() {
        return  orderDetailMapper.toDTOList(orderDetailRepo.findAll());
    }

    @Override
    public OrderDetailDTO updateOrderDetail(OrderDetailDTO orderDetailDTO) {
        OrderDetail updateOrderDetail = orderDetailRepo.findById(orderDetailDTO.getId()).get();
        updateOrderDetail.setBabySeat(orderDetailDTO.getBabySeat());
        updateOrderDetail.setWithDriver(orderDetailDTO.getWithDriver());
        updateOrderDetail.setClientName(orderDetailDTO.getClientName());
        updateOrderDetail.setClientPhone(orderDetailDTO.getClientPhone());
        updateOrderDetail.setClientEmail(orderDetailDTO.getClientEmail());
//        updateOrderDetail.setGetAddress(orderDetailDTO.getGetAddress());           На удаление
//        updateOrderDetail.setReturnAddress(orderDetailDTO.getReturnAddress());    На удаление
//        updateOrderDetail.setDateTimeFrom(orderDetailDTO.getDateTimeFrom());  На удаление
//        updateOrderDetail.setDateTimeTo(orderDetailDTO.getDateTimeTo());      На удаление
        updateOrderDetail.setPriceBeforeDiscount(orderDetailDTO.getPriceBeforeDiscount());
        updateOrderDetail.setPriceWithDiscount(orderDetailDTO.getPriceWithDiscount());
        return orderDetailMapper.toDto(updateOrderDetail);
    }
}