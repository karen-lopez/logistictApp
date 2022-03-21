package com.kl.logisticts.apirest.entitys.transport;

import static com.kl.logisticts.apirest.validations.Validation.validateFormat;
import lombok.Getter;

@Getter
public class Fleet implements ITransport {

    private String fleetNumber;
    
    private static final String TRANSPORT_TYPE = "Sea";
    private static final String REGEX_VALIDATE_FLEET_NUMBER = "[A-Z]{3}\\d{4}[A-Z]{1}";
    private static final String INVALID_FLEET_NUMBER_FORMAT = "Invalid fleet number format, correct format example: ABC1234D";

    public Fleet(String fleetNumber) {
        validateFormat(REGEX_VALIDATE_FLEET_NUMBER, fleetNumber, INVALID_FLEET_NUMBER_FORMAT);
        this.fleetNumber = fleetNumber;
    }

    @Override
    public String getTypeTransport() {
        return TRANSPORT_TYPE;
    }

}
