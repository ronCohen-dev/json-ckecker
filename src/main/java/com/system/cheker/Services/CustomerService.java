package com.system.cheker.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.cheker.exception.CustomerExseption;
import com.system.cheker.exception.ErrorMassage;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

@Service
public class CustomerService {

    private ObjectMapper objectMapper = new ObjectMapper();



    public String checkCustomerJson(String customerJson) throws CustomerExseption {
        File schemaFile = new File("target/classes/SwaggerApiJson.json");

        JSONTokener schemaData = null;
        try {
            schemaData = new JSONTokener(new FileInputStream(schemaFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CustomerExseption(ErrorMassage.FALIE_JSON_MUST_EXSISTS);
        }
        Map<String, String> input = null;
        try {
            input = objectMapper.readValue(customerJson, Map.class);
        } catch (JsonProcessingException e) {
            throw new CustomerExseption(ErrorMassage.INSERT_WORG_DETELSE);
        }
        JSONObject jsonSchema = new JSONObject(schemaData);
        JSONObject components = jsonSchema.getJSONObject("components");
        JSONObject schema = components.getJSONObject("schemas");
        JSONObject customer = schema.getJSONObject("Customer");
        Set<String> propertiesJson = customer.getJSONObject("properties").keySet();
        boolean response = false;
        if (Objects.equals(propertiesJson.size(), input.size())) {
            for (String pJson : propertiesJson) {
                for (String pBean : input.keySet()) {
                    if (pBean.equalsIgnoreCase(pJson)) {
                        response = true;
                        break;
                    }else {
                        response = false;
                    }

                }
            }
        } else {
            response = false;
        }
return response ? "success" : "failure";
    }

}