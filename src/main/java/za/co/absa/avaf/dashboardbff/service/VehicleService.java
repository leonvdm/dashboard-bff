package za.co.absa.avaf.dashboardbff.service;

import za.co.absa.avaf.dashboardbff.domain.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> getAllVehicles();

    List<Vehicle> findByMake(String make);
}
