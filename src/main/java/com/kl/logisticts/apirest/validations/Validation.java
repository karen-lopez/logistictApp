package com.kl.logisticts.apirest.validations;

import com.kl.logisticts.apirest.validations.exceptions.ExceptionIncorrectFormat;
import java.util.regex.Pattern;

public class Validation {
    
    public static void validateFormat(String regex, String value, String message){
        if(!Pattern.matches(regex, value)){
            throw new ExceptionIncorrectFormat(message);
        }   
    }
    
}
