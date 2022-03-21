package com.kl.logisticts.apirest.entitys.delivery;

import static com.kl.logisticts.apirest.validations.Validation.validateNotNull;
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
    private static final String DELIVERY_PRODUCT_TYPE_IS_REQUIRED = "Delivery product type is required.";
    private static final String DELIVERY_TOTAL_PRODUCT_IS_REQUIRED = "Delivery total product is required.";
    private static final String DELIVERY_PREGISTRATION_DATE_IS_REQUIRED = "Delivery registration date is required.";
    private static final String DELIVERY_DATE_IS_REQUIRED = "Delivery date is required.";
    private static final String DELIVERY_PRICE_IS_REQUIRED = "Delivery price is required.";
    private static final String DELIVERY_TRACKING_NUMBER_IS_REQUIRED = "Delivery tracking number is required.";
    private static final String DELIVERY_CLIENT_ID_IS_REQUIRED = "Delivery client id is required.";

    public Delivery(String productType, Integer totalProduct, Date registrationDate, Date deliveryDate, BigDecimal price, String trackingNumber, String clientId) {
        validateNotNull(productType, DELIVERY_PRODUCT_TYPE_IS_REQUIRED);
        validateNotNull(totalProduct, DELIVERY_TOTAL_PRODUCT_IS_REQUIRED);
        validateNotNull(registrationDate, DELIVERY_PREGISTRATION_DATE_IS_REQUIRED);
        validateNotNull(deliveryDate, DELIVERY_DATE_IS_REQUIRED);
        validateNotNull(price, DELIVERY_PRICE_IS_REQUIRED);
        validateNotNull(trackingNumber, DELIVERY_TRACKING_NUMBER_IS_REQUIRED);
        validateNotNull(clientId, DELIVERY_CLIENT_ID_IS_REQUIRED);
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
