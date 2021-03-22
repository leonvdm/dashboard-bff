package za.co.absa.avaf.dashboardbff.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.co.absa.avaf.dashboardbff.domain.Vehicle;
import za.co.absa.avaf.dashboardbff.service.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles/")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("{make}")
    @ResponseStatus(HttpStatus.OK)
    public List<Vehicle> getVehiclesByMake(@PathVariable String make) {
        return vehicleService.findByMake(make);
    }

}
