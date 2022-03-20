package com.kl.logisticts.apirest.entitys.transport;

import static com.kl.logisticts.apirest.validations.Validation.validateFormat;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
public class Vehicle implements ITransport{
    @Id
    private String id;
    private String licensePlate;
    private static final String REGEX_VALIDATE_LICENSE_PLATE = "[A-Z]{3}\\d{3}";
    private static final String INVALID_LICENSE_PLATE_FORMAT = "Invalid licence plate format, correct format example: ABC123";
    
    public Vehicle(String licensePlate){
        validateFormat(REGEX_VALIDATE_LICENSE_PLATE, licensePlate, INVALID_LICENSE_PLATE_FORMAT);
        this.licensePlate = licensePlate;
    }
    
    @Override
    public String getIdentification() {
        return this.licensePlate;
    }
    
}
