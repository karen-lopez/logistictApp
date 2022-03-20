package com.kl.logisticts.apirest.entitys;

import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.AllArgsConstructor;


@Document
@Data
@AllArgsConstructor
public class Client{
    @Id
    private String id;
    private Long documentNumber; 
    private String name;

}
