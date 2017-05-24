package com.rxx.designpattern.bridge;
/**
 * @Title      :SourceSub1
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月6日 下午5:18:58
 */
public class SourceSub1 implements Sourceable {

	@Override
	public void method() {
		System.out.println("this is the first sub!");  
	}

}
