package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class BeanWithJsonAutoDetectTests {

    @Test
    public void WhenBeanHasJsonAutoDetectAnnotation_ThenSerialize_ExpectCorrect() throws JsonProcessingException {
        // when
        BeanWithJsonAutoDetect bean = new BeanWithJsonAutoDetect(1, "Jungmin", "password");

        // then
        String json = new ObjectMapper().writeValueAsString(bean);

        // expected
        System.out.println(json);
        assertThat(json, not(containsString("password")));
    }
}
