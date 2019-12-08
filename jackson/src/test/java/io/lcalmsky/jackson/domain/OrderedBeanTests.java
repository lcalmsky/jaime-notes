package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class OrderedBeanTests {

    @Test
    @DisplayName("@JsonPropertyOrder 적용한 뒤 순서 확인")
    public void givenOrderedBeanUsingJsonPropertyOrder_whenWriteJson_thenOrderedJson() throws JsonProcessingException {
        // given
        OrderedBean orderedBean = new OrderedBean();
        orderedBean.setId(UUID.randomUUID().toString());
        orderedBean.setName("홍길동");
        orderedBean.setAge(30);

        // when
        String json = new ObjectMapper().writeValueAsString(orderedBean);

        // then
        System.out.println(json);
    }
}