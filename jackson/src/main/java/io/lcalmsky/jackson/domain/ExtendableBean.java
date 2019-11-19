package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class ExtendableBean {
    private String name;
    private Map<String, Object> properties;

    public ExtendableBean(String name) {
        this.name = name;
        this.properties = new HashMap<>();
    }

    protected ExtendableBean() {
        this.properties = new HashMap<>();
    }

    @JsonAnyGetter
    public Map<String, Object> getProperties() {
        return properties;
    }

    @JsonAnySetter
    public void add(String key, Object value) {
        properties.put(key, value);
    }

    @JsonGetter
    public String getUnitName() {
        return this.name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ExtendableBean.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("properties=" + properties)
                .toString();
    }
}