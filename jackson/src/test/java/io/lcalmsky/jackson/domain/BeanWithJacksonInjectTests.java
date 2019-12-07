package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeanWithJacksonInjectTests {
    @Test
    @DisplayName("JsonInjection필드에 값 주입하기")
    public void givenJsonWithoutSomeFieldProvided_whenInjectAndDeserialize_thenCorrect() throws JsonProcessingException {
        // given
        String json = "{\"name\":\"name\"}";

        // when
        InjectableValues injectableValues = new InjectableValues.Std().addValue(int.class, 1);
        BeanWithJacksonInject bean = new ObjectMapper().reader(injectableValues).forType(BeanWithJacksonInject.class).readValue(json);

        // then
        assertAll(
                () -> assertEquals(1, bean.getId()),
                () -> assertEquals("name", bean.getName())
        );

        // log
        System.out.println(json);
        System.out.println(bean);
    }
}