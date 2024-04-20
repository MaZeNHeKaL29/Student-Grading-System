package test;

import studentGradingSystem.GradeCalculator;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GradeCalculatorTest {
    @Test
    void test97To100() throws Exception {
        for(int i = 97; i <= 100; i++)
            assertEquals("A+", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test93To97() throws Exception {
        for(int i = 93; i < 97; i++)
            assertEquals("A", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test89To93() throws Exception {
        for(int i = 89; i < 93; i++)
            assertEquals("A-", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test84To89() throws Exception {
        for(int i = 84; i < 89; i++)
            assertEquals("B+", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test80To84() throws Exception {
        for(int i = 80; i < 84; i++)
            assertEquals("B", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test76To80() throws Exception {
        for(int i = 76; i < 80; i++)
            assertEquals("B-", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test73To76() throws Exception {
        for(int i = 73; i < 76; i++)
            assertEquals("C+", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test70To73() throws Exception {
        for(int i = 70; i < 73; i++)
            assertEquals("C", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test67To70() throws Exception {
        for(int i = 67; i < 70; i++)
            assertEquals("C-", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test64To67() throws Exception {
        for(int i = 64; i < 67; i++)
            assertEquals("D+", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test60To64() throws Exception {
        for(int i = 60; i < 64; i++)
            assertEquals("D", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test0To60() throws Exception {
        for(int i = 0; i < 60; i++)
            assertEquals("F", GradeCalculator.calculateGrade(i));
    }

    @Test
    void test100() throws Exception {
        assertEquals("A+", GradeCalculator.calculateGrade(100));
    }

    @Test
    void test97() throws Exception {
        assertEquals("A+", GradeCalculator.calculateGrade(97));
    }

    @Test
    void testLessThan0() {
        assertThrows(Exception.class, () -> {
            GradeCalculator.calculateGrade(-1);
        });
    }

    @Test
    void testMoreThan100() {
        assertThrows(Exception.class, () -> {
            GradeCalculator.calculateGrade(101);
        });
    }
}
