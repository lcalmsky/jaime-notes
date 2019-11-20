package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonIgnoreProperties("password")
public class BeanWithIgnoreProperties {
    private String id;
    private String name;
    private String password;
}