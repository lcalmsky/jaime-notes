package io.lcalmsky.jackson.domain;

import io.lcalmsky.jackson.domain.annotation.CustomAnnotation;
import lombok.Data;

import java.util.Date;

@CustomAnnotation
@Data
public class BeanWithCustomAnnotation {
    private int id;
    private String name;
    private Date date;
}
