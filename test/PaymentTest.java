import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    private Address addr;

    @BeforeEach   // 每个 @Test 运行前都会执行，保证测试互不影响
    void setUp() {
        addr = new Address("12", "LE11 3TU", "Loughborough");
    }

    @Test
    void payPalReceiptMessage() {
        PaymentMethod method = new PayPal("dan@example.com");
        Receipt r = method.processPayment(25.5, addr);

        assertEquals("25.50 paid by PayPal using dan@example.com, "
                + "and the delivery address is 12, LE11 3TU, Loughborough.", r.getMessage());
    }

    @Test
    void creditCardReceiptMessage() {
        PaymentMethod method = new CreditCard("1234567812345678", "123");
        Receipt r = method.processPayment(39.99, addr);

        assertTrue(r.getMessage().startsWith("39.99 paid by Credit Card using 1234567812345678"));
    }

    @Test
    void amountIsRoundedToTwoDecimals() {
        Receipt r = new PayPal("x@y.com").processPayment(10.005, addr);
        assertTrue(r.getMessage().startsWith("10.01") || r.getMessage().startsWith("10.00"));
    }
}
