package test;

import studentGradingSystem.GPACalculator;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GPACalculatorTest {
	
    @Test
    void test97To100() throws Exception {
        for(int i = 97; i <= 100; i++)
            assertEquals(4.0, GPACalculator.calculateGPA(i));
    }

    @Test
    void test93To97() throws Exception {
        for(int i = 93; i < 97; i++)
            assertEquals(4.0, GPACalculator.calculateGPA(i));
    }

    @Test
    void test89To93() throws Exception {
        for(int i = 89; i < 93; i++)
            assertEquals(3.7, GPACalculator.calculateGPA(i));
    }

    @Test
    void test84To89() throws Exception {
        for(int i = 84; i < 89; i++)
            assertEquals(3.3, GPACalculator.calculateGPA(i));
    }

    @Test
    void test80To84() throws Exception {
        for(int i = 80; i < 84; i++)
            assertEquals(3.0, GPACalculator.calculateGPA(i));
    }

    @Test
    void test76To80() throws Exception {
        for(int i = 76; i < 80; i++)
            assertEquals(2.7, GPACalculator.calculateGPA(i));
    }

    @Test
    void test73To76() throws Exception {
        for(int i = 73; i < 76; i++)
            assertEquals(2.3, GPACalculator.calculateGPA(i));
    }

    @Test
    void test70To73() throws Exception {
        for(int i = 70; i < 73; i++)
            assertEquals(2.0, GPACalculator.calculateGPA(i));
    }

    @Test
    void test67To70() throws Exception {
        for(int i = 67; i < 70; i++)
            assertEquals(1.7, GPACalculator.calculateGPA(i));
    }

    @Test
    void test64To67() throws Exception {
        for(int i = 64; i < 67; i++)
            assertEquals(1.3, GPACalculator.calculateGPA(i));
    }

    @Test
    void test60To64() throws Exception {
        for(int i = 60; i < 64; i++)
            assertEquals(1.0, GPACalculator.calculateGPA(i));
    }

    @Test
    void test0T060() throws Exception {
        for(int i = 0; i < 60; i++)
            assertEquals(0.0, GPACalculator.calculateGPA(i));
    }

    @Test
    void test100() throws Exception {
        assertEquals(4.0, GPACalculator.calculateGPA(100));
    }

    @Test
    void test97() throws Exception {
        assertEquals(4.0, GPACalculator.calculateGPA(97));
    }

    @Test
    void testLessThan0() {
        assertThrows(Exception.class, () -> {
            GPACalculator.calculateGPA(-1);
        });
    }

    @Test
    void testMoreThan100() {
        assertThrows(Exception.class, () -> {
            GPACalculator.calculateGPA(101);
        });
    }
}
