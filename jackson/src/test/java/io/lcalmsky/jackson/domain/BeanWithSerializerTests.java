package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class BeanWithSerializerTests {
    @Test
    public void whenUsingCustomSerializer_thenWriteJson_expectCorrect() throws JsonProcessingException {
        // when
        BeanWithSerializer beanWithSerializer = new BeanWithSerializer();
        beanWithSerializer.setName("날짜");
        beanWithSerializer.setTime(LocalDate.of(2019, 11, 15));

        // then
        String json = new ObjectMapper().writeValueAsString(beanWithSerializer);

        // expected
        assertThat(json, containsString("2019년 11월 15일"));

        // print
        System.out.println(json);
    }
}
