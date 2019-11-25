package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class BeanWithReferenceTests {
    @Test
    public void WhenReferenceProvided_ThenSerialize_ExpectCorrect() throws JsonProcessingException {
        // when
        BeanWithJsonBackReference backBean = new BeanWithJsonBackReference();
        backBean.setId(1);
        backBean.setName("backBean");

        BeanWithJsonManagedReference managedBean = new BeanWithJsonManagedReference();
        managedBean.setId(2);
        managedBean.setName("managedBean");
        managedBean.setBean(backBean);

        List<BeanWithJsonManagedReference> beans = new ArrayList<>();
        beans.add(managedBean);
        backBean.setBeans(beans);

        // then
        String json1 = new ObjectMapper().writeValueAsString(backBean);
        String json2 = new ObjectMapper().writeValueAsString(managedBean);

        // expected
        System.out.println(json1);
        System.out.println(json2);

        assertThat(json1, not(containsString("beans")));
        assertThat(json2, containsString("backBean"));
    }
}
