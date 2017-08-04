package com.wisely.highlight_spring4.ch2.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		  AnnotationConfigApplicationContext context =  
				  new AnnotationConfigApplicationContext();
		  
		  context.getEnvironment().setActiveProfiles("prod"); //1
		  context.register(ProfileConfig.class);//2
		  context.refresh(); //3
		  
	      DemoBean demoBean = context.getBean(DemoBean.class);
		DemoBean2 demoBean2 = context.getBean(DemoBean2.class);
	      System.out.println(demoBean.getContent());
		System.out.println(demoBean2.getContent());
	      context.close();
	}
}
