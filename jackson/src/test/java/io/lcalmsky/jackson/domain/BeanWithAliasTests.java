package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeanWithAliasTests {
    @Test
    @DisplayName("@JsonAlias에 추가한 필드명으로 JSON을 구성하여 역직렬화하여도 같은 결과를 획득")
    public void givenJsonAliasProvided_whenDeserialize_thenCorrect() throws JsonProcessingException {
        // given
        String json1 = "{\"firstName\":\"Jungmin\",\"lastName\":\"Lee\"}";
        String json2 = "{\"first_name\":\"Jungmin\",\"lastName\":\"Lee\"}";
        String json3 = "{\"fName\":\"Jungmin\",\"lastName\":\"Lee\"}";

        // when
        ObjectMapper objectMapper = new ObjectMapper();
        BeanWithAlias bean1 = objectMapper.readValue(json1, BeanWithAlias.class);
        BeanWithAlias bean2 = objectMapper.readValue(json2, BeanWithAlias.class);
        BeanWithAlias bean3 = objectMapper.readValue(json3, BeanWithAlias.class);

        // then
        assertAll(
                () -> assertEquals(bean1.getFirstName(), bean2.getFirstName()),
                () -> assertEquals(bean2.getFirstName(), bean3.getFirstName())
        );

        // log
        System.out.println(bean1);
        System.out.println(bean2);
        System.out.println(bean3);
    }
}
