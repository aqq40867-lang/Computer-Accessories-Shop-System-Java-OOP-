import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void adminAndCustomerAreBothUsers() {
        Address a = new Address("15", "LE11 1QE", "Loughborough");
        User admin = new Admin(102, "admin1", "Jessica", a);
        User customer = new Customer(101, "Jett", "Daniel", a);

        assertTrue(admin instanceof Admin);
        assertFalse(customer instanceof Admin);   // Main 里 888 后门就靠这个判断权限
        assertEquals("admin1", admin.getUsername());
        assertSame(a, customer.getAddress());
    }

    @Test
    void addressToString() {
        assertEquals("12, LE11 3TU, Loughborough",
                new Address("12", "LE11 3TU", "Loughborough").toString());
    }
}
