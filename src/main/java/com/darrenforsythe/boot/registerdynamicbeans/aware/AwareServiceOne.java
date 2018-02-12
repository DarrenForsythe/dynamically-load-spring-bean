package com.darrenforsythe.boot.registerdynamicbeans.aware;

public class AwareServiceOne implements Aware, AwareService{

	@Override
	public String work() {
		return "one";
	}

}
