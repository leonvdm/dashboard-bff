package za.co.absa.avaf.dashboardbff.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import za.co.absa.avaf.schema.application.ApplicationSubmitted;
import za.co.absa.avaf.schema.contract.RequestForContractSubmitted;

@Slf4j
@Component
@RequiredArgsConstructor
public class RequestReceiver {

    @KafkaListener(topics = "${avaf.topic-names.application-submitted}", groupId = "${avaf.group-id}")
    public void handleApplication(final String applicationSubmitted) {
        try {
            log.info("**************************************************Received ApplicationSubmitted");
            log.info(applicationSubmitted);
        } catch (Exception e) {
            log.error("Something went wrong with processing application", e);
        }
    }

    @KafkaListener(topics = "${avaf.topic-names.request-for-contract-submitted}", groupId = "dev-avaf-contract")
    public void handleRequestForContract(final RequestForContractSubmitted rfcSubmitted) {
        try {
            log.debug("Received RequestForContractSubmitted");
        } catch (Exception e) {
            log.error("Something went wrong with processing request for contract", e);
        }
    }

//    @KafkaListener(topics = "${avaf.topic-names.application-amendment}", groupId = "${avaf.group-id}")
//    public <T> void handleRequest(final ConsumerRecord<String, T> record) {
//        try {
//            T request = record.value();
//            log.debug("Received {}", request.getClass().getSimpleName());
//            if (request instanceof EasyAmendRequest) {
//                requestHandler.handleEasyAmend((EasyAmendRequest) request);
//            } else if (request instanceof DealManagementAmendment) {
//                requestHandler.handleDealManagementAmendment((DealManagementAmendment) request);
//            } else if (request instanceof DocumentsUploadedEvent) {
//                requestHandler.handleDocumentsUploadedEvent((DocumentsUploadedEvent) request);
//            } else if (request instanceof DealActionResult) {
//                requestHandler.handleDealAction((DealActionResult) request);
//            } else if (request instanceof EContractAmendment) {
//                requestHandler.handleEContractAmendment((EContractAmendment) request);
//            } else if (request instanceof EContractSignature) {
//                requestHandler.handleEContractSignature((EContractSignature) request);
//            } else if (request instanceof AnalystProfilingResult) {
//                requestHandler.handleAnalystProfilingResult((AnalystProfilingResult) request);
//            } else if (request instanceof RequestForContract) {
//                requestHandler.handleRequestForContract((RequestForContract) request);
//            }
//        } catch (Exception e) {
//            log.error("Something went wrong with processing request", e);
//        } finally {
//            activityLog.clearActivities();
//        }
//    }
}
