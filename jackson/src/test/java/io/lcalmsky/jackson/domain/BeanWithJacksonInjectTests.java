package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BeanWithJacksonInjectTests {
    @Test
    public void whenJsonWithoutSomeFieldProvided_thenInjectAndDeserialize_expectCorrect() throws JsonProcessingException {
        // when
        String json = "{\"name\":\"name\"}";

        // then
        InjectableValues injectableValues = new InjectableValues.Std().addValue(int.class, 1);
        BeanWithJacksonInject bean = new ObjectMapper().reader(injectableValues).forType(BeanWithJacksonInject.class).readValue(json);

        // expect
        System.out.println(json);
        System.out.println(bean);
        assertEquals(1, bean.getId());
        assertEquals("name", bean.getName());
    }
}