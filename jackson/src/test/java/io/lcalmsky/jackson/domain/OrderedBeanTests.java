package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.UUID;

public class OrderedBeanTests {

    @Test
    public void whenOrderedBeanUsingJsonPropertyOrder_thenWriteJson_expectedOrderedJson() throws JsonProcessingException {
        // when
        OrderedBean orderedBean = new OrderedBean();
        orderedBean.setId(UUID.randomUUID().toString());
        orderedBean.setName("홍길동");
        orderedBean.setAge(30);

        // then
        String json = new ObjectMapper().writeValueAsString(orderedBean);

        // expected
        System.out.println(json);
    }
}
