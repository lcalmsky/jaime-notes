package io.lcalmsky.jackson.domain.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class EnumWithValueTests {
    @Test
    public void whenJsonValueApplied_thenSerialize_expectCorrect() throws JsonProcessingException {
        // when
        EnumWithValue enum1 = EnumWithValue.ENUM1;
        // then
        String enumValue = new ObjectMapper().writeValueAsString(enum1);
        // expected
        System.out.println(enumValue);
        assertThat(enumValue, is("1"));
    }
}