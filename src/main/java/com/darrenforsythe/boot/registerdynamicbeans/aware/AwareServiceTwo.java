package com.darrenforsythe.boot.registerdynamicbeans.aware;

public class AwareServiceTwo implements Aware, AwareService{

	@Override
	public String work() {
		return "two";
	}

}
