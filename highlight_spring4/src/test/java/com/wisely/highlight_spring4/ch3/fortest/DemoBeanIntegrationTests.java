package com.wisely.highlight_spring4.ch3.fortest;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //1 在JUnit环境下提供 spring testcontext Framework的功能
@ContextConfiguration(classes = {TestConfig.class}) //2
@ActiveProfiles("dev") //3
public class DemoBeanIntegrationTests {
	@Autowired //4
	private TestBean testBean;

	@Test //5
	public void prodBeanShouldInject(){
		String expected = "from development profile";
		String actual = testBean.getContent();
		Assert.assertEquals(expected, actual);
	}

	
}
