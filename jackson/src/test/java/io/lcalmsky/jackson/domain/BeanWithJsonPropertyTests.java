package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class BeanWithJsonPropertyTests {
    @Test
    public void WhenJsonPropertyProvided_ThenSerialize_ExpectCorrect() throws JsonProcessingException {
        // when
        BeanWithJsonProperty bean = new BeanWithJsonProperty();
        bean.setId(1);
        bean.setName("name");

        // then
        String json = new ObjectMapper().writeValueAsString(bean);

        // expected
        System.out.println(json);
        assertThat(json, containsString("nickname"));
        assertThat(json, containsString("identity"));
    }
}
