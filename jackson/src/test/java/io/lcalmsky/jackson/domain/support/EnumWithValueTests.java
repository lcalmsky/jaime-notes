package io.lcalmsky.jackson.domain.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnumWithValueTests {
    @Test
    @DisplayName("@JsonValue를 사용하여 enum 타입을 직렬화하기")
    public void givenJsonValueApplied_whenSerialize_thenCorrect() throws JsonProcessingException {
        // given
        EnumWithValue enum1 = EnumWithValue.ENUM1;

        // when
        String enumValue = new ObjectMapper().writeValueAsString(enum1);

        // then
        assertEquals("1", enumValue);

        // log
        System.out.println(enumValue);
    }
}