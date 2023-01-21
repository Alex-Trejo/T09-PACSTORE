package ec.edu.espe.ecomarket.controller;

import java.util.List;

/**
 *
 * @author David Toapanta, Pacstore, DCCO-ESPE
 */
public class AlertProduct {

    private static final int MINIMUM_QUANTITY = 10;

    public static void checkProducts(List<Integer> products) {
        for (Integer product : products) {
            if (product < MINIMUM_QUANTITY) {
                System.out.println("Alert: The quantity of one of the products is less than " + MINIMUM_QUANTITY + ".");
                return;
            }
        }
        System.out.println("All products have a quantity greater than or equal to " + MINIMUM_QUANTITY + ".");
    }
}
