// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

// public class CalculatorTest {

//     @Test
//     void testSquareRoot() {
//         assertEquals(5.0, Calculator.squareRoot(25));
//     }

//     @Test
//     void testFactorial() {
//         assertEquals(120, Calculator.factorial(5));
//     }

//     @Test
//     void testNaturalLog() {
//         assertEquals(0.0, Calculator.naturalLog(1), 0.0001);
//     }

//     @Test
//     void testPower() {
//         assertEquals(8.0, Calculator.power(2, 3));
//     }
// }
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    // ---------- Square Root Tests ----------
    @Test
    void testSquareRoot_Normal() {
        assertEquals(5.0, Calculator.squareRoot(25));
    }

    @Test
    void testSquareRoot_Zero() {
        assertEquals(0.0, Calculator.squareRoot(0));
    }

    @Test
    void testSquareRoot_Decimal() {
        assertEquals(1.5, Calculator.squareRoot(2.25), 0.0001);
    }

    // Wrong input: negative number
    @Test
    void testSquareRoot_Negative() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.squareRoot(-4);
        });
    }

    // ---------- Factorial Tests ----------
    @Test
    void testFactorial_Normal() {
        assertEquals(120, Calculator.factorial(5));
    }

    @Test
    void testFactorial_Zero() {
        assertEquals(1, Calculator.factorial(0)); // base case
    }

    @Test
    void testFactorial_One() {
        assertEquals(1, Calculator.factorial(1)); // base case
    }

    // Wrong input: negative number
    @Test
    void testFactorial_Negative() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.factorial(-3);
        });
    }

    // ---------- Natural Log Tests ----------
    @Test
    void testNaturalLog_Normal() {
        assertEquals(0.0, Calculator.naturalLog(1), 0.0001);
    }

    @Test
    void testNaturalLog_E() {
        assertEquals(1.0, Calculator.naturalLog(Math.E), 0.0001);
    }

    // Wrong input: zero
    @Test
    void testNaturalLog_Zero() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.naturalLog(0);
        });
    }

    // Wrong input: negative
    @Test
    void testNaturalLog_Negative() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.naturalLog(-5);
        });
    }

    // ---------- Power Tests ----------
    @Test
    void testPower_Normal() {
        assertEquals(8.0, Calculator.power(2, 3));
    }

    @Test
    void testPower_ZeroExponent() {
        assertEquals(1.0, Calculator.power(5, 0)); // base case
    }

    @Test
    void testPower_ZeroBase() {
        assertEquals(0.0, Calculator.power(0, 5));
    }

    @Test
    void testPower_NegativeExponent() {
        assertEquals(0.25, Calculator.power(2, -2), 0.0001);
    }

    @Test
    void testPower_One() {
        assertEquals(7.0, Calculator.power(7, 1));
    }
}