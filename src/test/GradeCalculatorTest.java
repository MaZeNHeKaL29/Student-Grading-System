package test;

import studentGradingSystem.GradeCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GradeCalculatorTest {
    @Test
    void test97To100() {
        for(int i = 97; i <= 100; i++)
            assertEquals("A+", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test93To97() {
        for(int i = 93; i < 97; i++)
            assertEquals("A", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test89To93() {
        for(int i = 89; i < 93; i++)
            assertEquals("A-", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test84To89() {
        for(int i = 84; i < 89; i++)
            assertEquals("B+", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test80To84() {
        for(int i = 80; i < 84; i++)
            assertEquals("B", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test76To80() {
        for(int i = 76; i < 80; i++)
            assertEquals("B-", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test73To76() {
        for(int i = 73; i < 76; i++)
            assertEquals("C+", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test70To73() {
        for(int i = 70; i < 73; i++)
            assertEquals("C", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test67To70() {
        for(int i = 67; i < 70; i++)
            assertEquals("C-", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test64To67() {
        for(int i = 64; i < 67; i++)
            assertEquals("D+", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test60To64() {
        for(int i = 60; i < 64; i++)
            assertEquals("D", GradeCalculator.calculateGrade(i));
    }

    @Test
    void testLessThan60() {
        for(int i = 0; i < 60; i++)
            assertEquals("F", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test100() {
        assertEquals("A+", GradeCalculator.calculateGrade(100));
    }

    @Test
    void test97() {
        assertEquals("A+", GradeCalculator.calculateGrade(97));
    }
}
