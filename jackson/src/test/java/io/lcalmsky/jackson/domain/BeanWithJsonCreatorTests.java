package io.lcalmsky.jackson.domain;

        import com.fasterxml.jackson.core.JsonProcessingException;
        import com.fasterxml.jackson.databind.ObjectMapper;
        import org.junit.Test;

        import static org.hamcrest.CoreMatchers.is;
        import static org.hamcrest.MatcherAssert.assertThat;
        import static org.junit.Assert.assertEquals;

public class BeanWithJsonCreatorTests {
    @Test
    public void whenJsonCreatorApplied_thenDeserialize_expectCorrect() throws JsonProcessingException {
        // when
        String json = "{\"id\":1,\"theName\":\"beanName\"}";

        // then
        BeanWithJsonCreator bean = new ObjectMapper().readValue(json, BeanWithJsonCreator.class);

        // expect
        System.out.println(json);
        System.out.println(bean);
        assertEquals("beanName", bean.getName());
        assertThat(bean.getId(), is(1));
    }
}
