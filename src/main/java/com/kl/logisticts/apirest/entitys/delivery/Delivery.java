package com.kl.logisticts.apirest.entitys.delivery;

import com.kl.logisticts.apirest.entitys.transport.ITransport;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
public abstract class Delivery {
    @Id
    protected String id;
    protected String productType;
    protected Integer totalProduct;
    protected Date registrationDate;
    protected Date deliveryDate;
    protected BigDecimal price;
    protected BigDecimal discountPrice;
    protected String trackingNumber;
    protected String clientId;
    @Transient
    protected ITransport transport;
    
    protected static final Integer TOTAL_PRODUCTS_FOR_DISCOUNT_GREATER_THAN = 5;

    public Delivery(String productType, Integer totalProduct, Date registrationDate, Date deliveryDate, BigDecimal price, String trackingNumber, String clientId) {
        this.productType = productType;
        this.totalProduct = totalProduct;
        this.registrationDate = registrationDate;
        this.deliveryDate = deliveryDate;
        this.price = price;
        this.trackingNumber = trackingNumber;
        this.clientId = clientId;
        this.discountPrice = this.price;
    }
    
    abstract protected ITransport createTransport();
    
    abstract protected void validateDiscount();
    
    public void applyDiscount(Integer discountRate){
        BigDecimal discount = this.price.divide(BigDecimal.valueOf(100)).multiply(BigDecimal.valueOf(discountRate));
        this.discountPrice = this.price.subtract(discount); 
    }
    
}
