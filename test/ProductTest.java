import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void keyboardStoresAllFields() {
        Keyboard k = new Keyboard(123456, "Corsair", "black", ConnectivityType.WIRED,
                39.99, ProductCategory.KEYBOARD, "gaming", "UK");

        assertEquals(123456, k.getBarcode());
        assertEquals("Corsair", k.getBrand());
        assertEquals(ConnectivityType.WIRED, k.getConnectivity());
        assertEquals(39.99, k.getRetailPrice(), 0.001); // double 比较要给误差
        assertEquals("UK", k.getLayout());
    }

    @Test
    void mouseToStringContainsKeyInfo() {
        Mouse m = new Mouse(112233, "Logitech", "black", ConnectivityType.WIRELESS,
                25.50, ProductCategory.MOUSE, "gaming", 5);

        String s = m.toString();
        assertTrue(s.startsWith("112233"));
        assertTrue(s.contains("Logitech"));
        assertTrue(s.endsWith(", 5"));
    }

    @Test
    void productsArePolymorphic() {
        Product p = new Mouse(1, "A", "grey", ConnectivityType.WIRED, 6.99, ProductCategory.MOUSE, "std", 2);
        assertInstanceOf(Mouse.class, p);
        assertEquals(ProductCategory.MOUSE, p.getCategory());
    }
}
