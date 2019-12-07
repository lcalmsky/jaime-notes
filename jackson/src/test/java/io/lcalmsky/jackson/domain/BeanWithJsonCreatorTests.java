package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeanWithJsonCreatorTests {
    @Test
    @DisplayName("@JsonCreator를 이용하여 역직렬화")
    public void givenJsonCreatorApplied_whenDeserialize_thenCorrect() throws JsonProcessingException {
        // given
        String json = "{\"id\":1,\"theName\":\"beanName\"}";

        // when
        BeanWithJsonCreator bean = new ObjectMapper().readValue(json, BeanWithJsonCreator.class);

        // then
        assertEquals("beanName", bean.getName());
        assertEquals(1, bean.getId());

        // log
        System.out.println(json);
        System.out.println(bean);
    }
}
