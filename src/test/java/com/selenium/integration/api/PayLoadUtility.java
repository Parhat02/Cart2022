package com.selenium.integration.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PayLoadUtility {
    public static String getCustomerPayLoad(){
        long timeStamp=System.currentTimeMillis();
        String payLoad=null;
        CustomerPayload customerPayload=new CustomerPayload("abdullah"+timeStamp+"@gmail","Mr","Abdullah"+timeStamp,"Karluk"+timeStamp,
                "0","023-464678",1,"En","254.687.897.654",1);
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            payLoad=objectMapper.writeValueAsString(customerPayload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return payLoad;
    }
}
