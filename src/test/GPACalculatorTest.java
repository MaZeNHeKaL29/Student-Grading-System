package test;

import studentGradingSystem.GPACalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GPACalculatorTest {
    @Test
    void test97To100() {
        for(int i = 97; i <= 100; i++)
            assertEquals(4.0, GPACalculator.calculateGPA(i));
    }

    @Test
    void test93To97() {
        for(int i = 93; i <= 97; i++)
            assertEquals(4.0, GPACalculator.calculateGPA(i));
    }

    @Test
    void test89To93() {
        for(int i = 89; i < 93; i++)
            assertEquals(3.7, GPACalculator.calculateGPA(i));
    }

    @Test
    void test84To89() {
        for(int i = 84; i < 89; i++)
            assertEquals(3.3, GPACalculator.calculateGPA(i));
    }

    @Test
    void test80To84() {
        for(int i = 80; i < 84; i++)
            assertEquals(3.0, GPACalculator.calculateGPA(i));
    }

    @Test
    void test76To80() {
        for(int i = 76; i < 80; i++)
            assertEquals(2.7, GPACalculator.calculateGPA(i));
    }

    @Test
    void test73To76() {
        for(int i = 73; i < 76; i++)
            assertEquals(2.3, GPACalculator.calculateGPA(i));
    }

    @Test
    void test70To73() {
        for(int i = 70; i < 73; i++)
            assertEquals(2.0, GPACalculator.calculateGPA(i));
    }

    @Test
    void test67To70() {
        for(int i = 67; i < 70; i++)
            assertEquals(1.7, GPACalculator.calculateGPA(i));
    }

    @Test
    void test64To67() {
        for(int i = 64; i < 67; i++)
            assertEquals(1.3, GPACalculator.calculateGPA(i));
    }

    @Test
    void test60To64() {
        for(int i = 60; i < 64; i++)
            assertEquals(1.0, GPACalculator.calculateGPA(i));
    }

    @Test
    void testLessThan60() {
        for(int i = 0; i < 60; i++)
            assertEquals(0.0, GPACalculator.calculateGPA(i));
    }

    @Test
    void test100() {
        assertEquals(4.0, GPACalculator.calculateGPA(100));
    }

    @Test
    void test99() {
        assertEquals(4.0, GPACalculator.calculateGPA(99));
    }

    @Test
    void test97() {
        assertEquals(4.0, GPACalculator.calculateGPA(97));
    }
}
