package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class BeanWithJsonViewTests {
    @Test
    public void WhenJsonViewProvided_ThenSerialize_ExpectCorrect() throws JsonProcessingException {
        // when
        BeanWithJsonView bean = new BeanWithJsonView();
        bean.setId(1);
        bean.setName("name");
        bean.setPassword("password");

        // then
        String json = new ObjectMapper().writerWithView(BeanWithJsonView.View.Public.class).writeValueAsString(bean);

        // expected
        System.out.println(json);
        assertThat(json, not(containsString("password")));
    }
}
