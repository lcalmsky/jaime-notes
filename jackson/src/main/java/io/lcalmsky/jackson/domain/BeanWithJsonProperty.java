package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class BeanWithJsonProperty {
    @Getter
    @Setter
    @JsonProperty("identity")
    private int id;
    private String name;

    @JsonProperty("nickname")
    public String getName() {
        return name;
    }

    @JsonProperty("nickname")
    public void setName(String name) {
        this.name = name;
    }
}
