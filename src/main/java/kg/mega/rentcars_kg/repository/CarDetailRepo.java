package kg.mega.rentcars_kg.repository;

import kg.mega.rentcars_kg.model.CarDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDetailRepo extends JpaRepository<CarDetail,Long> {
//    @Query(value = "select id from cardetail",nativeQuery = true)
//    List<Long> findAllId();

}
