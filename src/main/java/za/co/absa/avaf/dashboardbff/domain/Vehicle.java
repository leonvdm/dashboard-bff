package za.co.absa.avaf.dashboardbff.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime receivedDateTime;
    private String type;
    private String vehicleType;
    private String articleType;
    private String equipmentDescription;
    private String tcmCode;
    private String mmCode;
    private String make;
    private String model;
    private String numberOfSeats;
    private String mileage;
    private String engineSize;
    private String engineNumber;
    private String chassisNumber;
    private String registrationNumber;
    private String registrationYear;
    private String dateOfFirstRegistration;
    private String serialNumber;
    private String totalExtras;
    private String newPrice;
    private String retailPrice;
    private String tradePrice;

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }


    public LocalDateTime getReceivedDateTime() {
        return receivedDateTime;
    }

    public void setReceivedDateTime(LocalDateTime receivedDate) {
        this.receivedDateTime = receivedDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getEquipmentDescription() {
        return equipmentDescription;
    }

    public void setEquipmentDescription(String equipmentDescription) {
        this.equipmentDescription = equipmentDescription;
    }

    public String getTcmCode() {
        return tcmCode;
    }

    public void setTcmCode(String tcmCode) {
        this.tcmCode = tcmCode;
    }

    public String getMmCode() {
        return mmCode;
    }

    public void setMmCode(String mmCode) {
        this.mmCode = mmCode;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(String registrationYear) {
        this.registrationYear = registrationYear;
    }

    public String getDateOfFirstRegistration() {
        return dateOfFirstRegistration;
    }

    public void setDateOfFirstRegistration(String dateOfFirstRegistration) {
        this.dateOfFirstRegistration = dateOfFirstRegistration;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTotalExtras() {
        return totalExtras;
    }

    public void setTotalExtras(String totalExtras) {
        this.totalExtras = totalExtras;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(String tradePrice) {
        this.tradePrice = tradePrice;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", articleType='" + articleType + '\'' +
                ", equipmentDescription='" + equipmentDescription + '\'' +
                ", tcmCode='" + tcmCode + '\'' +
                ", mmCode='" + mmCode + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", numberOfSeats='" + numberOfSeats + '\'' +
                ", mileage='" + mileage + '\'' +
                ", engineSize='" + engineSize + '\'' +
                ", engineNumber='" + engineNumber + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", registrationYear='" + registrationYear + '\'' +
                ", dateOfFirstRegistration='" + dateOfFirstRegistration + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", totalExtras='" + totalExtras + '\'' +
                ", newPrice='" + newPrice + '\'' +
                ", retailPrice='" + retailPrice + '\'' +
                ", tradePrice='" + tradePrice + '\'' +
                '}';
    }
}
