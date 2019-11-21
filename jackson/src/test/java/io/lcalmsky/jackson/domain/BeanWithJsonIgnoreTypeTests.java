package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class BeanWithJsonIgnoreTypeTests {
    @Test
    public void WhenJsonIgnoreTypeProvided_ThenSerialize_ExpectedIgnored() throws JsonProcessingException {
        // when
        BeanWithJsonIgnoreType.Name name = new BeanWithJsonIgnoreType.Name();
        name.setFirstName("Jungmin");
        name.setLastName("Lee");
        BeanWithJsonIgnoreType bean = new BeanWithJsonIgnoreType();
        bean.setId(1);
        bean.setName(name);

        // then
        String json = new ObjectMapper().writeValueAsString(bean);

        // expected
        System.out.println(json);
        Assert.assertThat(json, CoreMatchers.not(CoreMatchers.containsString("Jungmin")));
        Assert.assertThat(json, CoreMatchers.not(CoreMatchers.containsString("Lee")));
        Assert.assertThat(json, CoreMatchers.not(CoreMatchers.containsString("name")));
    }
}
