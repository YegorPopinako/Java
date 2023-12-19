import org.example.Cart;
import org.example.ECommerceService;
import org.example.Order;
import org.example.Product;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ECommerceTest {

    private ECommerceService eCommerceService;
    private Cart cart;

    @Before
    public void setUp() {
        cart = new Cart();
        eCommerceService = new ECommerceService(cart);
    }

    @Test
    public void testAddToCart() {
        Product product = new Product(1, "Laptop", 999.99);
        assertTrue(eCommerceService.addToCart(product));
        assertEquals(1, cart.getProducts().size());
    }

    @Test
    public void testRemoveFromCart() {
        Product product = new Product(1, "Laptop", 999.99);
        eCommerceService.addToCart(product);
        assertTrue(eCommerceService.removeFromCart(1));
        assertEquals(0, cart.getProducts().size());
    }

    @Test
    public void testPlaceOrder() {
        Product product1 = new Product(1, "Laptop", 999.99);
        Product product2 = new Product(2, "Smartphone", 499.99);

        eCommerceService.addToCart(product1);
        eCommerceService.addToCart(product2);

        Order order = eCommerceService.placeOrder();
        assertNotNull(order);
        assertEquals(Order.Status.PENDING, order.getStatus());
        assertTrue(cart.getProducts().isEmpty());
    }

    @Test
    public void testOrderStatus() {
        Product product = new Product(1, "Laptop", 999.99);
        eCommerceService.addToCart(product);

        Order order = eCommerceService.placeOrder();
        assertNotNull(order);

        assertEquals(Order.Status.PENDING, order.getStatus());

        eCommerceService.cancelOrder();
        assertEquals(Order.Status.CANCELED, order.getStatus());

        eCommerceService.completeOrder();
        assertEquals(Order.Status.COMPLETED, order.getStatus());
    }
}
