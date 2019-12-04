package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class BeanWithOptionalTests {

    private String json;

    @Test
    @DisplayName("Optional 필드를 직렬화하면 값이 포함되지 않음")
    public void givenBeanWithOptional_whenSerialize_thenNotContainsRealValue() throws JsonProcessingException {
        // given
        BeanWithOptional.Name name = givenName("GOAT");

        // when
        json = whenSerialize(name);

        // then
        assertFalse(() -> json.contains("GOAT"));
    }

    @Test
    @DisplayName("Optional 필드를 직렬화하면 isPresent의 값이 포함됨")
    public void givenBeanWithOptional_whenSerialize_thenContainsWhetherItPresent() throws JsonProcessingException {
        // given
        BeanWithOptional.Name name = givenName("GOAT");

        // when
        json = whenSerialize(name);

        // then
        assertTrue(() -> json.contains("true"));
    }

    @Test
    @DisplayName("Optional 필드를 null로 지정하면 isPresent값이 false로 지정됨")
    public void givenBeanWithOptionalWithoutFieldValue_whenSerialize_thenContainsFalse() throws JsonProcessingException {
        // given
        BeanWithOptional.Name name = givenName(null);

        // when
        json = whenSerialize(name);

        // then
        assertTrue(() -> json.contains("false"));
    }

    private String whenSerialize(BeanWithOptional.Name name) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(name);
    }

    private BeanWithOptional.Name givenName(String nickname) {
        BeanWithOptional.Name name = new BeanWithOptional.Name();
        name.setFirstName("Lionel");
        name.setLastName("Messi");
        name.setNickname(Optional.ofNullable(nickname));
        return name;
    }

    @Test
    @DisplayName("Optional 필드에 값이 포함된 JSON을 역직렬화하면 예외가 발생함")
    public void givenJsonWithRealValue_whenDeserialize_thenThrowsJsonMappingException() throws JsonProcessingException {
        // given
        json = "{\"firstName\":\"Lionel\",\"lastName\":\"Messi\",\"nickname\":\"GOAT\"}";

        // when & then
        assertThrows(
                JsonMappingException.class,
                () -> new ObjectMapper().readValue(json, BeanWithOptional.Name.class)
        );
    }

    @Test
    @DisplayName("Optional 필드에 값이 포함된 JSON을 setter를 지정하여 역직렬화하면 성공함")
    public void givenJsonWithRealValueAndSetter_whenDeserialize_thenSuccess() throws JsonProcessingException {
        // given
        json = "{\"firstName\":\"Lionel\",\"lastName\":\"Messi\",\"nickname\":\"GOAT\"}";

        // when
        BeanWithOptional.NameWithOptionalSetter name = new ObjectMapper().readValue(json, BeanWithOptional.NameWithOptionalSetter.class);

        // then
        assertTrue(() -> name.getNickname().filter("GOAT"::equals).isPresent());
        System.out.println(name);
    }

    @AfterEach
    public void teardown() {
        System.out.println(json);
    }
}