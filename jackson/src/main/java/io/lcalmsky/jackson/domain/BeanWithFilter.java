package io.lcalmsky.jackson.domain;

        import com.fasterxml.jackson.annotation.JsonFilter;
        import lombok.Data;

@Data
@JsonFilter("myFilter")
public class BeanWithFilter {
    private int id;
    private String name;
}
