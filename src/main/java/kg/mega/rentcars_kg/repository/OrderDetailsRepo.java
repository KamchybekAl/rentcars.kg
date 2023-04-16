package kg.mega.rentcars_kg.repository;

import kg.mega.rentcars_kg.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails,Long> {

}
