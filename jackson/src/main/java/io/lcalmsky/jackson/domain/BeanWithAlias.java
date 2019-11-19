package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BeanWithAlias {
    @JsonAlias({"first_name", "fName"})
    private String firstName;
    private String lastName;
}