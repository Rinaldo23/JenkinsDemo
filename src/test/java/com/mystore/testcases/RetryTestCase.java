package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTestCase {
	
	@Test
    public void Demo1() {
		System.out.println("Demo1");
		Assert.assertEquals(1, 1);
	}
	
	@Test
    public void Demo2() {
		System.out.println("Demo2");
		Assert.assertEquals(1, 1);
	}
	
	@Test
    public void Demo3() {
		System.out.println("Demo3");
		Assert.assertEquals(1, 15);
	}
	
	@Test
    public void Demo4() {
		System.out.println("Demo4");
		Assert.assertEquals(1, 1);
	}
}
