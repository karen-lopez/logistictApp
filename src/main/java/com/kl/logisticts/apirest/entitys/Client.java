package com.kl.logisticts.apirest.entitys;

import org.springframework.data.mongodb.core.mapping.Document;
import static com.kl.logisticts.apirest.validations.Validation.validateNotNull;
import org.springframework.data.annotation.Id;
import lombok.Getter;


@Document
@Getter
public class Client{
    @Id
    private String id;
    private Long documentNumber; 
    private String name;
    
    private static final String CLIENT_DOCUMENT_NUMBER_IS_REQUIRED = "Client document number is required.";
    private static final String CLIENT_NAME_IS_REQUIRED = "Client name is required.";

    
    public Client(Long documentNumber, String name) {
        validateNotNull(documentNumber, CLIENT_DOCUMENT_NUMBER_IS_REQUIRED);
        validateNotNull(name, CLIENT_NAME_IS_REQUIRED);
        this.documentNumber = documentNumber;
        this.name = name;
    }

    
}
