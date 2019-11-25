package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class BeanWithFilterTests {
    @Test
    public void WhenJsonFilterProvided_ThenSerialize_ExpectCorrect() throws JsonProcessingException {
        // when
        BeanWithFilter bean = new BeanWithFilter();
        bean.setId(1);
        bean.setName("myBean");

        FilterProvider filterProvider = new SimpleFilterProvider()
                .addFilter("myFilter", SimpleBeanPropertyFilter.filterOutAllExcept("name"));

        // then
        String json = new ObjectMapper()
                .writer(filterProvider)
                .writeValueAsString(bean);

        // expected
        System.out.println(json);
        assertThat(json, containsString("myBean"));
        assertThat(json, not(containsString("id")));
    }
}
