package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BeanWithJsonCreator {
    private int id;
    private String name;

    @JsonCreator
    public BeanWithJsonCreator(
            @JsonProperty("id") int id,
            @JsonProperty("theName") String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BeanWithJsonCreator{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}