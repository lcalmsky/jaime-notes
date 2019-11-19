package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BeanWithJsonSetterTests {
    @Test
    public void WhenJsonSetterAppliedAndJsonProvided_ThenDeserialize_ExpectCorrect() throws JsonProcessingException {
        // when
        String json = "{\n" +
                "  \"id\": 1,\n" +
                "  \"myName\": \"Jungmin Lee\"\n" +
                "}";

        // then
        BeanWithJsonSetter bean = new ObjectMapper().readValue(json, BeanWithJsonSetter.class);

        // expect
        assertEquals("Jungmin Lee", bean.getName());
        System.out.println(json);
        System.out.println(bean);
    }
}
