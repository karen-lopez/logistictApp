package com.kl.logisticts.apirest.entitys.transport;

import org.junit.jupiter.api.Test;
import org.junit.Assert;


public class VehicleTest {
    
    @Test
    public void testGetIdentificationMustReturnALicensePlate() {
      String licensePlate = "ABC123";
      Vehicle vehicle = new Vehicle(licensePlate);
      String typeTransport = "Road";
      
      String result = vehicle.getTypeTransport();
      
      Assert.assertEquals(typeTransport, result);
    }
}
