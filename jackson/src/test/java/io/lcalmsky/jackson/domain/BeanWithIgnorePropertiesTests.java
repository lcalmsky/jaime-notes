package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class BeanWithIgnorePropertiesTests {
    @Test
    public void WhenJsonIgnorePropertiesProvided_ThenSerialize_ExpectIgnored() throws JsonProcessingException {
        // when
        BeanWithIgnoreProperties bean = new BeanWithIgnoreProperties();
        bean.setId("id");
        bean.setName("name");
        bean.setPassword("password");

        // then
        String json = new ObjectMapper().writeValueAsString(bean);

        // expected
        assertThat(json, not(containsString("password")));
        System.out.println(json);
    }
}
