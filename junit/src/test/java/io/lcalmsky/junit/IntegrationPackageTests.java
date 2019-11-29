package io.lcalmsky.junit;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("io.lcalmsky.junit") // 해당 패키지의 테스트를 모두 수행
public class IntegrationPackageTests {

}