package alexandr.repository;

import alexandr.entitys.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface CarRepo extends JpaRepository<Car, String> {

    @Query(value = "select count(*) from cars", nativeQuery = true)
    int countAll();

    @Query(value = "select create_data from cars where create_data = (select min(create_data) from cars)", nativeQuery = true)
    LocalDateTime getFirstCreateDate();

    @Query(value = "select create_data from cars where create_data = (select max(create_data) from cars)", nativeQuery = true)
    LocalDateTime getLastCreateDate();
}
