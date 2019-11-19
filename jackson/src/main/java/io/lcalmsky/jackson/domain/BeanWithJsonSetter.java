package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.StringJoiner;

public class BeanWithJsonSetter {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @JsonSetter
    public void setMyName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BeanWithJsonSetter.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .toString();
    }
}
