package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.lcalmsky.jackson.domain.serializer.CustomDateSerializer;

import java.time.LocalDate;

public class BeanWithSerializer {
    private String name;
    @JsonSerialize(using = CustomDateSerializer.class)
    private LocalDate time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }
}
