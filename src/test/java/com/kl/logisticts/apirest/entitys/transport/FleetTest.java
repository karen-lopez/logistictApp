package com.kl.logisticts.apirest.entitys.transport;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class FleetTest {

    @Test
    public void testGetIdentification() {
        String fleetNumber = "ABC1234D";
        Fleet fleet = new Fleet(fleetNumber);
        String typeTransport = "Sea";

        String result = fleet.getTypeTransport();

        Assert.assertEquals(typeTransport, result);
    }
}
