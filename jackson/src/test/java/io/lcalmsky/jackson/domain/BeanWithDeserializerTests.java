package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class BeanWithDeserializerTests {
    @Test
    public void WhenBeanWithDeserializerProvided_ThenDeserialize_ExpectCorrect() throws JsonProcessingException {
        // when
        String json = "{\"name\":\"today\",\"date\":\"2019-11-19 15:45:00\"}";

        // then
        BeanWithDeserializer bean = new ObjectMapper().readValue(json, BeanWithDeserializer.class);

        // expected
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        assertEquals("2019-11-19 15:45:00", format.format(bean.getDate()));
    }
}
