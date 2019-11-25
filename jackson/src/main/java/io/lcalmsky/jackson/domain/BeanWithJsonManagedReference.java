package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Data
public class BeanWithJsonManagedReference {
    private int id;
    private String name;

    @JsonManagedReference
    private BeanWithJsonBackReference bean;
}
