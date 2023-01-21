package ec.edu.espe.ecomarket.controller;

/**
 *
 * @author David Toapanta, Pacstore, DCCO-ESPE
 */
public class Discount {
    private static final int MINIMUM_QUANTITY = 10;
    private static final double DISCOUNT_RATE = 0.05;

    public static double applyDiscount(int quantity, double total) {
        if (quantity >= MINIMUM_QUANTITY) {
            return total - (total * DISCOUNT_RATE);
        }
        return total;
    }
}
