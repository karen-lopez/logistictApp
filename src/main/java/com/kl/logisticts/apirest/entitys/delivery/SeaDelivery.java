package com.kl.logisticts.apirest.entitys.delivery;

import com.kl.logisticts.apirest.entitys.transport.Fleet;
import com.kl.logisticts.apirest.entitys.transport.ITransport;
import java.math.BigDecimal;
import java.util.Date;

public final class SeaDelivery extends Delivery {

    private String port;
    private String fleetNumber;
    private static final Integer DISCOUNT_RATE = 3;

    public SeaDelivery(String port, String fleetNumber, String productType, Integer totalProduct, Date registrationDate, Date deliveryDate, BigDecimal price, String trackingNumber, String clientId) {
        super(productType, totalProduct, registrationDate, deliveryDate, price, trackingNumber, clientId);
        validateDiscount();
        this.port = port;
        this.fleetNumber = fleetNumber;
        this.transport = createTransport();
    }

    @Override
    protected final ITransport createTransport() {
        return new Fleet(this.fleetNumber);
    }

    @Override
    protected void validateDiscount() {
        if (this.totalProduct > TOTAL_PRODUCTS_FOR_DISCOUNT_GREATER_THAN) {
            applyDiscount(DISCOUNT_RATE);
        }
    }

}
