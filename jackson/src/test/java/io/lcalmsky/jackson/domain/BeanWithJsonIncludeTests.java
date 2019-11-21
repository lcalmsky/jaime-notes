package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class BeanWithJsonIncludeTests {
    @Test
    public void WhenBeanWithJsonIncludeProvided_ThenSerialize_ExpectCorrect() throws JsonProcessingException {
        // when
        BeanWithJsonInclude beanWithId = new BeanWithJsonInclude();
        beanWithId.setId(1);
        beanWithId.setName(null);

        BeanWithJsonInclude beanWithName = new BeanWithJsonInclude();
        beanWithName.setId(null);
        beanWithName.setName("name");

        // then
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonWithId = objectMapper.writeValueAsString(beanWithId);
        String jsonWithName = objectMapper.writeValueAsString(beanWithName);

        // expected
        System.out.println(jsonWithId);
        System.out.println(jsonWithName);
        assertThat(jsonWithId, not(containsString("name")));
        assertThat(jsonWithName, not(containsString("id")));
    }
}
