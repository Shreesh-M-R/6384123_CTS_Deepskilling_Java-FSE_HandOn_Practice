/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.advanced_junits;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
/**
 *
 * @author lavan
 */
@TestMethodOrder(OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void testFirst() {
        Assertions.assertTrue(true);
    }

    @Test
    @Order(2)
    void testSecond() {
        Assertions.assertTrue(true);
    }

    @Test
    @Order(3)
    void testThird() {
        Assertions.assertTrue(true);
    }
}

