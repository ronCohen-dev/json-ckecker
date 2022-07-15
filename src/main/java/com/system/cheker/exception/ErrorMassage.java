package com.system.cheker.exception;

public enum ErrorMassage {

    INSERT_WORG_DETELSE("Whis customer proparties not supported"),
    FALIE_JSON_MUST_EXSISTS("The json fale muse be in the program");

    private String desc;

    ErrorMassage(String desc) {
        this.desc = desc;
    }

    public String getDesc(){return desc;}
}
