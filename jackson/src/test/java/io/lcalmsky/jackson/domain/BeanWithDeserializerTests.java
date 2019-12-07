package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BeanWithDeserializerTests {
    @Test
    @DisplayName("Deserializer를 지정하여 날짜형식을 역직렬화함")
    public void givenBeanWithDeserializerProvided_whenDeserialize_thenCorrect() throws JsonProcessingException {
        // given
        String json = "{\"name\":\"today\",\"date\":\"2019-11-19 15:45:00\"}";

        // when
        BeanWithDeserializer bean = new ObjectMapper().readValue(json, BeanWithDeserializer.class);

        // then
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        assertEquals("2019-11-19 15:45:00", format.format(bean.getDate()));

        // log
        System.out.println(bean);
    }
}
