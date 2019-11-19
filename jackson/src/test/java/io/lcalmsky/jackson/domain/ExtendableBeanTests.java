package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class ExtendableBeanTests {

    @Test
    public void WhenSerializingUsingJsonAnyGetter_ThenWriteJson_ExpectedCorrect() throws JsonProcessingException {

        // when
        ExtendableBean bean = new ExtendableBean("hydralisk");
        bean.add("mineral", 100);
        bean.add("gas", 50);
        bean.add("morphable", true);
        bean.add("damage", 12);
        bean.add("armor", 0);

        // then
        String result = new ObjectMapper().writeValueAsString(bean);

        // expected
        assertThat(result, containsString("mineral"));
        assertThat(result, containsString("gas"));
        assertThat(result, containsString("morphable"));
        assertThat(result, containsString("damage"));
        assertThat(result, containsString("armor"));
        System.out.println(result);
    }

    @Test
    public void WhenJsonAnySetterAppliedAndJsonProvided_ThenDeserialize_ExpectCorrect() throws JsonProcessingException {
        // when
        String json = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"hydralisk\",\n" +
                "  \"damage\": \"10\",\n" +
                "  \"morphable\": true,\n" +
                "  \"hasHero\": true\n" +
                "}";

        // then
        ExtendableBean bean = new ObjectMapper().readValue(json, ExtendableBean.class);

        // expected
        assertTrue(bean.getProperties().containsKey("hasHero"));
        System.out.println(bean);
    }
}
