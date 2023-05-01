package kg.mega.rentcars_kg.repository;

import kg.mega.rentcars_kg.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepo extends JpaRepository<Price, Long> {
    @Query(value = "select * from tb_price where car_id = :carId and end_date > now()",nativeQuery = true)
    Price getActualPrice(Long carId);

//    @Query(value = "select *  from price where now() < price.end_day and room_id = :roomId",
//            nativeQuery = true)

}
