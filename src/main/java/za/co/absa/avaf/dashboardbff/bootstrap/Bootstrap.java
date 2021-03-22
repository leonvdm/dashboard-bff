package za.co.absa.avaf.dashboardbff.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import za.co.absa.avaf.dashboardbff.domain.Vehicle;
import za.co.absa.avaf.dashboardbff.repository.VehicleRepository;

@Component
public class Bootstrap implements CommandLineRunner {

    private VehicleRepository vehicleRepository;

    public Bootstrap(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Vehicle mustang1 = new Vehicle();
        mustang1.setMake("Ford");
        mustang1.setArticleType("Mustang1");

        Vehicle vw = new Vehicle();
        vw.setMake("VW");
        vw.setArticleType("Polo");

        Vehicle porsche = new Vehicle();
        porsche.setMake("Porsche");
        porsche.setArticleType("911");

        vehicleRepository.save(mustang1);
        vehicleRepository.save(vw);
        vehicleRepository.save(porsche);

    }
}
//sql file that autoloads for h2 in resources

