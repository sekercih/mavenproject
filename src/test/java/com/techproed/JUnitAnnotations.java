package com.techproed;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class JUnitAnnotations {
    @Before
    public void runBeforeTest(){
        System.out.println("@Before => run before test");
    }
    @After
    public void runAfterTest(){
        System.out.println("@After => run after test");
    }@Ignore
    @Test
    public void test1(){
        System.out.println("Test1  yazdır");
    }
@Test
    public void test2(){
    System.out.println( "Test2 yazdır.");
}@Before

    public void test3(){
        System.out.println("Test3 yazdır");
    }
}
