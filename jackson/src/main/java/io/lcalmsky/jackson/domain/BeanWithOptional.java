package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

public class BeanWithOptional {
    @Data
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Name {
        private String firstName;
        private String lastName;
        private Optional<String> nickname;
    }

    @Data
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class NameWithOptionalSetter {
        private String firstName;
        private String lastName;
        private Optional<String> nickname;

        @JsonSetter
        public void setNickname(String nickname) {
            this.nickname = Optional.ofNullable(nickname);
        }
    }
}