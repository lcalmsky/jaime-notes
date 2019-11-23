package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

@Data
public class BeanWithJsonUnwrapped {
    private int id;

    @JsonUnwrapped
    public Name name;

    @Data
    public static class Name {
        private String firstName;
        private String lastName;
    }
}
