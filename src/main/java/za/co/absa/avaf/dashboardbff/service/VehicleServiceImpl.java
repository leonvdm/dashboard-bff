package za.co.absa.avaf.dashboardbff.service;

import org.springframework.stereotype.Service;
import za.co.absa.avaf.dashboardbff.domain.Vehicle;
import za.co.absa.avaf.dashboardbff.repository.VehicleRepository;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return  vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> findByMake(String make) {
        return vehicleRepository.findByMake(make);
    }
}
