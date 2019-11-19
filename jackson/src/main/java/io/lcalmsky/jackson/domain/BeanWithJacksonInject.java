package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.annotation.JacksonInject;

import java.util.StringJoiner;

public class BeanWithJacksonInject {
    @JacksonInject
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BeanWithJacksonInject.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .toString();
    }
}