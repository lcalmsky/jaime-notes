package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BeanWithSerializerTests {
    @Test
    @DisplayName("CustomSerializer를 사용해 역직렬화하기")
    public void givenUsingCustomSerializer_whenWriteJson_thenCorrect() throws JsonProcessingException {
        // given
        BeanWithSerializer beanWithSerializer = new BeanWithSerializer();
        beanWithSerializer.setName("날짜");
        beanWithSerializer.setTime(LocalDate.of(2019, 11, 15));

        // when
        String json = new ObjectMapper().writeValueAsString(beanWithSerializer);

        // then
        assertTrue(json.contains("2019년 11월 15일"));

        // log
        System.out.println(json);
    }
}
