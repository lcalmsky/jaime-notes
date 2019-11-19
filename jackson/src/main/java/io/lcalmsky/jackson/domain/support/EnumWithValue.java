package io.lcalmsky.jackson.domain.support;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumWithValue {

    ENUM1(1, "TYPE1"),
    ENUM2(2, "TYPE2");

    private Integer intValue;
    private String strValue;

    private EnumWithValue(Integer intValue, String strValue) {
        this.intValue = intValue;
        this.strValue = strValue;
    }

    @JsonValue
    public Integer getIntValue() {
        return intValue;
    }

    public String getStrValue() {
        return strValue;
    }
}
