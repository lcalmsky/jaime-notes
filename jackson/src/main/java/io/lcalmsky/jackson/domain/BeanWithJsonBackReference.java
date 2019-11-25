package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.util.List;

@Data
public class BeanWithJsonBackReference {
    private int id;
    private String name;
    @JsonBackReference
    private List<BeanWithJsonManagedReference> beans;
}