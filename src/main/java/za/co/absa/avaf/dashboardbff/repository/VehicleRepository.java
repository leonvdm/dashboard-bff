package za.co.absa.avaf.dashboardbff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.absa.avaf.dashboardbff.domain.Vehicle;

import java.util.List;


public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByMake(String make);

}
