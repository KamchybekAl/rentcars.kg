package kg.mega.rentcars_kg.service.impl;

import kg.mega.rentcars_kg.mapper.OrderDetailMapper;
import kg.mega.rentcars_kg.model.OrderDetail;
import kg.mega.rentcars_kg.model.dto.OrderDetailDTO;
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
    @Override
    public OrderDetailDTO saveOrderDetail(OrderDetailDTO orderDetailDTO) {
        OrderDetail orderDetail = orderDetailMapper.toEntity(orderDetailDTO);
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
        updateOrderDetail.setGetAddress(orderDetailDTO.getGetAddress());
        updateOrderDetail.setReturnAddress(orderDetailDTO.getReturnAddress());
        updateOrderDetail.setDateTimeFrom(orderDetailDTO.getDateTimeFrom());
        updateOrderDetail.setDateTimeTo(orderDetailDTO.getDateTimeTo());
        updateOrderDetail.setPriceBeforeDiscount(orderDetailDTO.getPriceBeforeDiscount());
        updateOrderDetail.setPriceWithDiscount(orderDetailDTO.getPriceWithDiscount());
        return orderDetailMapper.toDto(updateOrderDetail);
    }
}
