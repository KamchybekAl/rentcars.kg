package kg.mega.rentcars_kg.repository;

import kg.mega.rentcars_kg.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepo extends JpaRepository<Discount,Long> {
}
