package io.lcalmsky.junit;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

@DisplayName("title")
public class DisplayNameAndDisabledTests {
    @Test
    @DisplayName("I think this is most useful")
    public void test() {

    }

    @Test
    @Disabled("Not implemented yet")
    public void testNotImplemented() {

    }
}
