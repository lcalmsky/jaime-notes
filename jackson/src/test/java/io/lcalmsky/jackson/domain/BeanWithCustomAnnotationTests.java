package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class BeanWithCustomAnnotationTests {
    @Test
    public void WhenCustomAnnotationProvided_ThenSerialize_ExpectCorrect() throws JsonProcessingException {
        // when
        BeanWithCustomAnnotation bean = new BeanWithCustomAnnotation();
        bean.setId(1);
        bean.setName("name");
        bean.setDate(null);

        // then
        String json = new ObjectMapper().writeValueAsString(bean);

        // expected
        System.out.println(json);
        assertThat(json, containsString("id"));
        assertThat(json, containsString("name"));
        assertThat(json, not(containsString("date")));
    }
}
