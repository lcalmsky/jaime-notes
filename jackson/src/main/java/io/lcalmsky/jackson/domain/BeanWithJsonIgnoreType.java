package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BeanWithJsonIgnoreType {
    private int id;
    private Name name;

    @Data
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @JsonIgnoreType
    public static class Name {
        private String firstName;
        private String lastName;
    }
}