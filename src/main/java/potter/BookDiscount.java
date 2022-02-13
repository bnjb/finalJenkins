package potter;

import java.util.HashMap;
import java.util.Map;

public class BookDiscount {

    // Discounts applied in function of different set of books
    private static final Map<Integer, Double> discounts = new HashMap<Integer, Double>() {
        {
            put(1, 0.0d);
            put(2, 0.05d);
            put(3, 0.1d);
            put(4, 0.2d);
            put(5, 0.25d);
        }
    };

    public static double getBookDiscount(int size) {
        return discounts.get(size);
    }

}