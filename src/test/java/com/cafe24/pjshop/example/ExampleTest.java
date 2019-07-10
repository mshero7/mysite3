package com.cafe24.pjshop.example;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;



public class ExampleTest {
	// 테스트 케이스(메소드)끼리 공유해야 할 변수가 있으면 
	// static을 해주어라.
	private static StringBuilder output = new StringBuilder();
	@BeforeClass
	public static void setUpBefore() {
		System.out.println("@BeforeClass");
	}
	
	@AfterClass
	// 다 지우고 나오는 작업을 해주어야 함.
	public static void tearDownAfter() {
		System.out.println("@AfterClass");
		System.out.println(output);
	}
	
	// @Test 가 실행될때 마다 before, after 가 실행된다.
	@Before
	public void setUp() {
		System.out.println("@Before");
	}
	
	@After
	public void tearDown() {
		System.out.println("@After");
	}
	
	@Test
	public void myATest() {
		System.out.println("@Test:A");
		output.append("A");
	}
	
	@Test
	public void myBTest() {
		System.out.println("@Test:B");
		output.append("B");
	}
	
	@Test
	public void myCTest() {
		System.out.println("@Test:C");
		output.append("C");
	}
	
	/*
	 * assertXYZ 테스트
	 * */
	
	// 필요없는 테스트케이스는 주석으로 막지말고 Ignore를 해서 무시되게끔 한다.
	@Ignore
	@Test
	public void ignorerTest() {
		assertTrue(false);
	}
	
	@Test
	public void testAssert1() {
		Object[] a = {"java","JUnit", "Spring"};
		Object[] b = {"java","JUnit", "Spring"};
		assertArrayEquals(a,b);
	}
	
	@Test
	public void testAssert() {
		assertTrue(true);
		assertFalse(false);
		
		assertNull(null);
		assertNotNull(new Object());
		
		// Equals는 값비교 (동치성)
		assertEquals(1+2, 3, 4-1);
		assertEquals(new String("hello"), "hello");
		assertNotEquals(true, false);
		assertEquals(new Integer(1), new Integer(1));
		
		// 동일성을 비교함. (자주 쓰이지만은 않음)
		assertSame("Hello", "Hello");
		assertNotSame(new String("Hello"), "Hello");
		assertNotSame(new Integer(1), new Integer(1));
		
		// assertThat
		assertThat(1+2, is(3));
		assertThat("this is never", is(not("that")));
		
		// assertThat : allOf
		assertThat("hello World", allOf(startsWith("hell"), containsString("o") ));

		// assertThat : anyOf
		assertThat("hello World", anyOf(startsWith("hell"), containsString("heaven")));
		
		// assertThat : both
		assertThat("ABC", both(containsString("A")).and(containsString("C")));
		
		// assertThat : either
		assertThat("ABC", either(containsString("A")).or(containsString("D")));
		
		// assertThat : everyItem
		assertThat(Arrays.asList("Apple", "Application", "Apolo"), everyItem(startsWith("Ap")));
		
		// assertThat : hasItem
		assertThat(Arrays.asList("Apple", "Black", "Banana"), hasItem("Banana"));
	}
	
	
}