package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RawBeanTests {
    @Test
    @DisplayName("JSON값 그대로 직렬화한뒤 확인")
    public void givenJsonRawValueApplied_whenWriteJson_thenRawValue() throws JsonProcessingException {
        // given
        RawBean bean = new RawBean("My bean", "{\"attr\":false}");

        // when
        String result = new ObjectMapper().writeValueAsString(bean);

        // then
        assertTrue(result.contains("My bean"));
        assertTrue(result.contains("{\"attr\":false}"));

        // log
        System.out.println(result);
    }
}