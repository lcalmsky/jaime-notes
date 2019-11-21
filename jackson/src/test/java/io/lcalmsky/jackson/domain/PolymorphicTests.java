package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class PolymorphicTests {
    @Test
    public void WhenPolymorphicBeanProvided_ThenSerialize_ExpectCorrect() throws JsonProcessingException {
        // when
        Zoo.Dog dog = new Zoo.Dog("lacy");
        Zoo zoo = new Zoo(dog);

        // then
        String json = new ObjectMapper().writeValueAsString(zoo);

        // expected
        System.out.println(json);
        assertThat(json, containsString("type"));
        assertThat(json, containsString("dog"));
    }
}