package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BeanWithJsonSetterTests {
    @Test
    @DisplayName("JsonSetter를 이용하여 역직렬화하기")
    public void givenJsonSetterAppliedAndJsonProvided_whenDeserialize_thenCorrect() throws JsonProcessingException {
        // given
        String json = "{\n" +
                "  \"id\": 1,\n" +
                "  \"myName\": \"Jungmin Lee\"\n" +
                "}";

        // when
        BeanWithJsonSetter bean = new ObjectMapper().readValue(json, BeanWithJsonSetter.class);

        // then
        assertEquals("Jungmin Lee", bean.getName());

        // log
        System.out.println(json);
        System.out.println(bean);
    }
}
