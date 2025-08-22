package junit_4_18;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3), "2 + 3 は 5 になるはず");
        assertEquals(4, calculator.add(-1, 5), "-1 + 5 は 4 になるはず");
        assertEquals(4, calculator.add(0, 4), "0 + 4 は 4 になるはず");
    }

    @Test
    void testSubtract() {
        Calculator calculator = new Calculator();
        assertEquals(2,  calculator.subtract(5, 3),  "5 - 3 は 2 になるはず");
        assertEquals(-3, calculator.subtract(-1, 2), "-1 - 2 は -3 になるはず");
        assertEquals(4,  calculator.subtract(4, 0),  "4 - 0 は 4 になるはず");
    }

    @Test
    void testZeroPattern() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.add(0, 0), "0 + 0 は 0 になるはず");
        assertEquals(0, calculator.subtract(0, 0), "0 - 0 は 0 になるはず");
        assertEquals(-5, calculator.subtract(-5, 0), "-5 - 0 は -5 になるはず");
    }

    @Test
    void testNegativePattern() {
        Calculator calculator = new Calculator();
        assertEquals(-10, calculator.add(-3, -7), "-3 + (-7) は -10 になるはず");
        assertEquals(-2, calculator.subtract(-5, -3), "-5 - (-3) は -2 になるはず");
        assertEquals(15, calculator.subtract(10, -5), "10 - (-5) は 15 になるはず");
    }
}
