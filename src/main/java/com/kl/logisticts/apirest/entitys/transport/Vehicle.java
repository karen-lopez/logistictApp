package com.kl.logisticts.apirest.entitys.transport;

import static com.kl.logisticts.apirest.validations.Validation.validateFormat;
import lombok.Getter;

@Getter
public class Vehicle implements ITransport{
    private String licensePlate;
    
    private static final String TRANSPORT_TYPE = "Road";
    private static final String REGEX_VALIDATE_LICENSE_PLATE = "[A-Z]{3}\\d{3}";
    private static final String INVALID_LICENSE_PLATE_FORMAT = "Invalid licence plate format, correct format example: ABC123";
    
    public Vehicle(String licensePlate){
        validateFormat(REGEX_VALIDATE_LICENSE_PLATE, licensePlate, INVALID_LICENSE_PLATE_FORMAT);
        this.licensePlate = licensePlate;
    }
    
    @Override
    public String getTypeTransport() {
        return TRANSPORT_TYPE;
    }
    
}
