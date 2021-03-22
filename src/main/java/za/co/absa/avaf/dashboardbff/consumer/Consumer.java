package za.co.absa.avaf.dashboardbff.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import za.co.absa.avaf.dashboardbff.domain.Vehicle;
import za.co.absa.avaf.dashboardbff.repository.VehicleRepository;

import java.time.LocalDateTime;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
    private final VehicleRepository vehicleRepository;

    public Consumer(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @KafkaListener(topics = "za.co.absa.avaf.asset", groupId = "group_id")
    public void consume(String message){

        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehicle = null;
        try {
            vehicle = mapper.readValue(message, Vehicle.class);
            vehicle.setReceivedDateTime(LocalDateTime.now());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        logger.info(String.format("$$$ -> Consumed Message -> %s",message));
        vehicleRepository.save(vehicle);
    }
}