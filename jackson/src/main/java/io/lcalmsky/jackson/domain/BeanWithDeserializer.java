package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.lcalmsky.jackson.domain.deserializer.CustomDateDeserializer;

import java.util.Date;
import java.util.StringJoiner;

public class BeanWithDeserializer {
    private String name;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BeanWithDeserializer.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("date=" + date)
                .toString();
    }
}
