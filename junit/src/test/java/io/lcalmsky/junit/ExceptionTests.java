package io.lcalmsky.junit;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTests {
    @Test
    public void additionalExceptionCheck() {
        Exception exception = assertThrows(
                NumberFormatException.class,
                () -> Integer.valueOf(null),
                "message"
        );
        // exception에 대한 추가적인 체크를 해야하는 경우
        // doSomething(exception);
    }

    @Test
    public void assertThrowException() {
        assertThrows(
                NumberFormatException.class,
                () -> Integer.valueOf(null)
        );
    }
}
