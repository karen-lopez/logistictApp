package com.kl.logisticts.apirest.entitys;

import static com.kl.logisticts.apirest.validations.Validation.validateNotNull;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
public class Product {

    @Id
    private String id;
    private String type;
    private String name;

    private static final String PRODUCT_TYPE_IS_REQUIRED = "Product type is required";
    private static final String PRODUCT_NAME_IS_REQUIRED = "Product name is required";

    public Product(String type, String name) {
        validateNotNull(type, PRODUCT_TYPE_IS_REQUIRED);
        validateNotNull(name, PRODUCT_NAME_IS_REQUIRED);
        this.type = type;
        this.name = name;
    }

}
