package com.system.cheker.module.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.system.cheker.Services.CustomerService;
import com.system.cheker.exception.CustomerExseption;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequiredArgsConstructor
@RequestMapping("Api/customer")

public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public String addCustomer(@RequestBody String c) throws CustomerExseption, FileNotFoundException, JsonProcessingException {

        return customerService.checkCustomerJson(c);

    }

}
