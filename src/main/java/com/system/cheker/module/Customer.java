package com.system.cheker.module;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;




}
