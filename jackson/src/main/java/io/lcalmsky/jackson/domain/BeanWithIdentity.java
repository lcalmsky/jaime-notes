package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class BeanWithIdentity {
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id" // default
    )
    @Data
    public static class Item {
        private int id;
        private String name;
        private User owner;
    }

    @Data
    public static class User {
        private int id;
        private String name;
        private List<Item> items;

        public User() {
            items = new ArrayList<>();
        }
    }
}
