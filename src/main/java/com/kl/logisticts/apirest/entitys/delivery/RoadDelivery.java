package com.kl.logisticts.apirest.entitys.delivery;


import com.kl.logisticts.apirest.entitys.transport.ITransport;
import com.kl.logisticts.apirest.entitys.transport.Vehicle;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;

@Getter
public final class RoadDelivery extends Delivery{

    private String warehouse;
    private String licensePlate;
    private static final Integer DISCOUNT_RATE = 2;

    public RoadDelivery(String warehouse, String productType, Integer totalProduct, Date registrationDate, Date deliveryDate, BigDecimal price, String trackingNumber, String clientId, String licensePlate) {
        super(productType, totalProduct, registrationDate, deliveryDate, price, trackingNumber, clientId);
        validateDiscount();
        this.warehouse = warehouse;
        this.licensePlate = licensePlate;
        this.transport = createTransport();
    }
    
    
    @Override
    protected ITransport createTransport() {
        return new Vehicle(this.licensePlate);
    }

    @Override
    protected void validateDiscount() {
        if(this.totalProduct > TOTAL_PRODUCTS_FOR_DISCOUNT_GREATER_THAN){
            applyDiscount(DISCOUNT_RATE);
        }
    }
    
}
