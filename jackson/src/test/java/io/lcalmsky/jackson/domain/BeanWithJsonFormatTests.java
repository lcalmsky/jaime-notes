package io.lcalmsky.jackson.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class BeanWithJsonFormatTests {
    @Test
    public void WhenJsonFormatProvided_ThenSerialize_ExpectCorrect() throws ParseException, JsonProcessingException {
        // when
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateToParse = "2019-11-23 19:00:30";
        Date parsedDate = format.parse(dateToParse);
        BeanWithJsonFormat bean = new BeanWithJsonFormat();
        bean.setName("bean");
        bean.setDate(parsedDate);

        // then
        String json = new ObjectMapper().writeValueAsString(bean);

        // expected
        System.out.println(json);
        assertThat(json, containsString(dateToParse));
    }
}
