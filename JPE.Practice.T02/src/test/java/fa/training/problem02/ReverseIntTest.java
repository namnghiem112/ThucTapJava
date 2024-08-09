package fa.training.problem02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ReverseIntTest {

    @Test
    public void testReverseInt_PositiveNumber() {
        ReverseInt reverseInt = new ReverseInt();
        assertEquals(54321, reverseInt.reverseInt(12345));
    }

    @Test
    public void testReverseInt_SingleDigit() {
        ReverseInt reverseInt = new ReverseInt();
        assertEquals(7, reverseInt.reverseInt(7));
    }

    @Test
    public void testReverseInt_NumberEndingInZero() {
        ReverseInt reverseInt = new ReverseInt();
        assertEquals(54321, reverseInt.reverseInt(123450));
    }

    @Test
    public void testReverseInt_NumberWithRepeatedDigits() {
        ReverseInt reverseInt = new ReverseInt();
        assertEquals(111, reverseInt.reverseInt(111));
    }

    @Test
    public void testReverseInt_LargeNumber() {
        ReverseInt reverseInt = new ReverseInt();
        assertEquals(987654321, reverseInt.reverseInt(123456789));
    }
}
