import com.promotion_engine.configuration.ConfigurationProperties;
import com.promotion_engine.configuration.ExternalConfiguration;
import com.promotion_engine.model.Cart;
import com.promotion_engine.model.Product;
import com.promotion_engine.util.PriceList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CartTest {
    private static Cart cart;

    @BeforeAll
    public static void addItemsToCart() {
        cart = new Cart();
        Map<Product, Integer> testItems = new HashMap<>();
        testItems.put(new Product("A", 50), 1);
        testItems.put(new Product("B", 30), 1);
        testItems.put(new Product("C", 20), 1);
        testItems.put(new Product("D", 15), 1);
        cart.setContents(testItems);
    }

    @AfterAll
    public static void teardown() {
        cart.getContents().clear();
    }

    @Test
    public void testCartWithValidProductItems() {
        Double price = PriceList.getPrice("A");
        System.out.println(price);
        Assertions.assertNotNull(price, "Product invalid");
    }

    @Test
    public void testCartWithInvalidProductItem() {
        Double price = PriceList.getPrice("F");
        Assertions.assertNull(price, "Please add an invalid product to pass this test.");
    }
}
