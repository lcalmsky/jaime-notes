package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExtendableBeanTests {

    @Test
    @DisplayName("JsonAnyGetter를 사용하여 JSON 작성하기")
    public void givenSerializingUsingJsonAnyGetter_whenWriteJson_thenCorrect() throws JsonProcessingException {
        // given
        ExtendableBean bean = new ExtendableBean("hydralisk");
        bean.add("mineral", 100);
        bean.add("gas", 50);
        bean.add("morphable", true);
        bean.add("damage", 12);
        bean.add("armor", 0);

        // when
        String result = new ObjectMapper().writeValueAsString(bean);

        // then
        assertAll(
                () -> assertThat(result, containsString("mineral")),
                () -> assertThat(result, containsString("gas")),
                () -> assertThat(result, containsString("morphable")),
                () -> assertThat(result, containsString("damage")),
                () -> assertThat(result, containsString("armor"))
        );

        // log
        System.out.println(result);
    }

    @Test
    @DisplayName("JsonAnySetter를 적용하여 역직렬화하기")
    public void givenJsonAnySetterAppliedAndJsonProvided_whenDeserialize_ExpectCorrect() throws JsonProcessingException {
        // given
        String json = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"hydralisk\",\n" +
                "  \"damage\": \"10\",\n" +
                "  \"morphable\": true,\n" +
                "  \"hasHero\": true\n" +
                "}";

        // when
        ExtendableBean bean = new ObjectMapper().readValue(json, ExtendableBean.class);

        // then
        assertTrue(() -> bean.getProperties().containsKey("hasHero"));

        // log
        System.out.println(bean);
    }
}
