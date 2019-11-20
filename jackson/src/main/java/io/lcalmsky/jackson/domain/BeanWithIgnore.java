package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BeanWithIgnore {
    private String id;
    private String name;
    @JsonIgnore
    private String password;
}