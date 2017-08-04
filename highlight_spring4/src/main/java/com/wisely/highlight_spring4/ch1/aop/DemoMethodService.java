package com.wisely.highlight_spring4.ch1.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoMethodService {
	public int add(int a ,int b){

		return a+b;
	}
	public int acc(int i){

		return i++;
	}
}
