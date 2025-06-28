/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import com.mycompany.setting_up_junit.Calculator;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
/**
 *
 * @author lavan
 */
public class CalculatorTest {

        private Calculator calculator;

        @Before
        public void setUp() {
            calculator = new Calculator();
            System.out.println("Setup complete");
        }

        @After
        public void tearDown() {
            calculator = null;
            System.out.println("Teardown complete");
        }

        @Test
        public void testAllInOne() {
            int a = 10, b = 5;

            int sum = calculator.add(a, b);
            int diff = calculator.sub(a, b);
            int prod = calculator.mul(a, b);
            int quot = calculator.div(a, b);

            assertEquals(15, sum);
            assertEquals(5, diff);
            assertEquals(50, prod);
            assertEquals(2, quot);

            assertTrue(a > b);
            assertFalse(b > a);
            assertNotNull(calculator);
            assertNull(getNullObject());

            System.out.println("All tests passed in one method");
        }

        private Object getNullObject() {
            return null;
        }

}
