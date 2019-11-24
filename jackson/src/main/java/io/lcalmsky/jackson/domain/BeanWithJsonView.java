package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
public class BeanWithJsonView {

    @JsonView(View.Public.class)
    private int id;
    @JsonView(View.Public.class)
    private String name;
    @JsonView(View.Internal.class)
    private String password;


    public static class View {
        public static class Public {
        }

        public static class Internal extends Public {
        }
    }
}
