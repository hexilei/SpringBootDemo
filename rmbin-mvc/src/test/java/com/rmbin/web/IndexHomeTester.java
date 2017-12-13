package com.rmbin.web;

import org.junit.Test;
import com.rmbin.web.controller.IndexHome;
import junit.framework.Assert;

public class IndexHomeTester {
	@Test
	public void sayHello()
	{
		//mvc.perform(MockMvcRequestBuilders.get("/sayHelloStr").accept(MediaType.ALL)).andExpect()
		Assert.assertEquals("Hey, I'm louis.", new IndexHome().sayHello());
	}

}
