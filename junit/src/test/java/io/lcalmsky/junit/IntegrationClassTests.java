package io.lcalmsky.junit;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({AfterTests.class, AssertionTests.class, DisplayNameAndDisabledTests.class}) // 명시한 클래스들의 테스트를 수행
public class IntegrationClassTests {

}