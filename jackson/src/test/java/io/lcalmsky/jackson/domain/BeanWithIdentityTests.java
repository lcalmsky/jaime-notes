package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class BeanWithIdentityTests {
    @Test
    public void WhenJsonIdentityInfoProvided_ThenSerialize_ExpectCorrect() throws JsonProcessingException {
        // when
        BeanWithIdentity.User user = new BeanWithIdentity.User();
        user.setId(1);
        user.setName("valkyrie");

        BeanWithIdentity.Item item = new BeanWithIdentity.Item();
        item.setId(2);
        item.setName("spear");
        item.setOwner(user);

        user.getItems().add(item);

        // then
        String json = new ObjectMapper().writeValueAsString(item);

        // expected
        System.out.println(json);
        assertThat(json, containsString("spear"));
        assertThat(json, containsString("valkyrie"));
        assertThat(json, containsString("items"));
    }
}
