package com.darrenforsythe.boot.registerdynamicbeans.normal;

import com.darrenforsythe.boot.registerdynamicbeans.aware.AwareServiceOne;
import com.darrenforsythe.boot.registerdynamicbeans.aware.AwareServiceTwo;

/**
 * Normal service class.
 * @author Darren Forsythe
 *
 */
public class Service {
	
	private AwareServiceOne awareServiceOne;
	private AwareServiceTwo awareServiceTwo;
	
	/**
	 * @param awareServiceOne
	 * @param awareServiceTwo
	 */
	public Service(AwareServiceOne awareServiceOne, AwareServiceTwo awareServiceTwo) {
		this.awareServiceOne = awareServiceOne;
		this.awareServiceTwo = awareServiceTwo;
	}

	public String doThing() {
		return awareServiceOne.work()+awareServiceTwo.work()+"thing";
	}
}
