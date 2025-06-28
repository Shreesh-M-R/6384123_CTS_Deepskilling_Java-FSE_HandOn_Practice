package com.mycompany.advanced_junits;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author lavan
 */
public class PerformanceTesterTest {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void testPerformTaskWithinTime() {
        PerformanceTester tester = new PerformanceTester();
        tester.performTask();
    }
}

