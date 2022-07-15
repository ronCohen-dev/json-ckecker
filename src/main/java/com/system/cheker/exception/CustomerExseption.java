package com.system.cheker.exception;

public class CustomerExseption  extends Exception {

    public CustomerExseption (ErrorMassage e){
        super (e.getDesc());
    }
}
