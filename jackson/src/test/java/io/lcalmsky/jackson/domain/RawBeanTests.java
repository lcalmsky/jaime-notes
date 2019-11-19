package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class RawBeanTests {
    @Test
    public void whenJsonRawValueApplied_thenWriteJson_expectRawValue() throws JsonProcessingException {
        // when
        RawBean bean = new RawBean("My bean", "{\"attr\":false}");

        // then
        String result = new ObjectMapper().writeValueAsString(bean);

        // expected
        assertThat(result, containsString("My bean"));
        assertThat(result, containsString("{\"attr\":false}"));
        System.out.println(result);
    }
}
