package com.wisely.highlight_spring4.ch2.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {
	@Bean
	@Profile("dev") //1
	public DemoBean devDemoBean() {
		return new DemoBean("from development profile");
	}

	@Bean
	@Profile("prod") //2
	public DemoBean prodDemoBean() {
		return new DemoBean("from production profile");
	}

	@Bean
	@Profile("test") //3
	public DemoBean testDemoBean() {
		return new DemoBean("from test profile");
	}

	@Bean
	//@Profile("demo") //3
	public DemoBean2 demoBean() {
		return new DemoBean2("from demo profile");
	}
}
