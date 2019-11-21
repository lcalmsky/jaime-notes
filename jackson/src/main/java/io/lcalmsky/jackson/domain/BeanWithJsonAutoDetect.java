package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NON_PRIVATE)
public class BeanWithJsonAutoDetect {
    public int id;
    protected String name;
    private String password;

    public BeanWithJsonAutoDetect(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
