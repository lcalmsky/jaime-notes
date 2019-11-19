package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BeanWithAliasTests {
    @Test
    public void WhenJsonAliasProvided_ThenDeserialize_ExpectCorrect() throws JsonProcessingException {
        // when
        String json1 = "{\"firstName\":\"Jungmin\",\"lastName\":\"Lee\"}";
        String json2 = "{\"first_name\":\"Jungmin\",\"lastName\":\"Lee\"}";
        String json3 = "{\"fName\":\"Jungmin\",\"lastName\":\"Lee\"}";

        // then
        ObjectMapper objectMapper = new ObjectMapper();
        BeanWithAlias bean1 = objectMapper.readValue(json1, BeanWithAlias.class);
        BeanWithAlias bean2 = objectMapper.readValue(json2, BeanWithAlias.class);
        BeanWithAlias bean3 = objectMapper.readValue(json3, BeanWithAlias.class);

        // expected
        System.out.println(bean1);
        System.out.println(bean2);
        System.out.println(bean3);
        assertEquals(bean1.getFirstName(), bean2.getFirstName());
        assertEquals(bean2.getFirstName(), bean3.getFirstName());
    }
}
