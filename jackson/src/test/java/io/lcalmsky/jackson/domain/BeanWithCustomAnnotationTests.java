package io.lcalmsky.jackson.domain;

        import com.fasterxml.jackson.core.JsonProcessingException;
        import com.fasterxml.jackson.databind.ObjectMapper;
        import org.junit.jupiter.api.DisplayName;
        import org.junit.jupiter.api.Test;

        import static org.hamcrest.CoreMatchers.not;
        import static org.hamcrest.core.StringContains.containsString;
        import static org.junit.Assert.assertThat;
        import static org.junit.jupiter.api.Assertions.assertAll;

public class BeanWithCustomAnnotationTests {
    @Test
    @DisplayName("CustonAnnotation을 사용하여 직렬화하기")
    public void givenCustomAnnotationProvided_whenSerialize_thenCorrect() throws JsonProcessingException {
        // given
        BeanWithCustomAnnotation bean = new BeanWithCustomAnnotation();
        bean.setId(1);
        bean.setName("name");
        bean.setDate(null);

        // when
        String json = new ObjectMapper().writeValueAsString(bean);

        // then
        assertAll(
                () -> assertThat(json, containsString("id")),
                () -> assertThat(json, containsString("name")),
                () -> assertThat(json, not(containsString("date")))
        );

        // log
        System.out.println(json);
    }
}
