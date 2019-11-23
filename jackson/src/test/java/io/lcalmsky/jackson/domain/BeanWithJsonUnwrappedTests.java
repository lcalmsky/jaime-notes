package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

public class BeanWithJsonUnwrappedTests {
    @Test
    public void WhenJsonUnwrappedProvided_ThenSerialize_ExpectCorrect() throws JsonProcessingException {
        // when
        BeanWithJsonUnwrapped bean = new BeanWithJsonUnwrapped();
        bean.setId(1);
        BeanWithJsonUnwrapped.Name name = new BeanWithJsonUnwrapped.Name();
        name.setFirstName("firstName");
        name.setLastName("lastName");
        bean.setName(name);

        // then
        String json = new ObjectMapper().writeValueAsString(bean);

        // expected
        System.out.println(json);
        assertThat(json, not(containsString("name")));
    }

    @Test
    public void WhenJsonWithFlatFieldsProvided_ThenDeserialize_ExpectCorrect() throws JsonProcessingException {
        // when
        String json = "{\"id\":0,\"firstName\":\"firstname\",\"lastName\":\"lastname\"}";

        // then
        BeanWithJsonUnwrapped bean = new ObjectMapper().readValue(json, BeanWithJsonUnwrapped.class);

        // expected
        System.out.println(bean);
        assertNotNull(bean.getName());
    }
}
