package com.kl.logisticts.apirest.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class Product {
    @Id
    private String id;
    private String type;
    private String name;
}
