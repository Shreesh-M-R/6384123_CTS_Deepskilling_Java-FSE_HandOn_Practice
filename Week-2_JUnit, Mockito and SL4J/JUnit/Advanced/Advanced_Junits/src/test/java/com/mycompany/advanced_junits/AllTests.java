package com.mycompany.advanced_junits;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
/**
 *
 * @author lavan
 */
@Suite
@SelectClasses({
        EvenCheckerTest.class,
        ExceptionThrowerTest.class,
        PerformanceTesterTest.class,
        OrderedTests.class
})
public class AllTests {
}