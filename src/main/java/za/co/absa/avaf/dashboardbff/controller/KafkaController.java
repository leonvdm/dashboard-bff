package za.co.absa.avaf.dashboardbff.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.absa.avaf.dashboardbff.producer.Producer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    public KafkaController(Producer producer) {

        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody String vehicle){
        this.producer.sendMessage(vehicle);

    }
}