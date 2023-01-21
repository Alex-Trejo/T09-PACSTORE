package ec.edu.espe.ecomarket.controller;

/**
 *
 * @author David Toapanta, Pacstore, DCCO-ESPE
 */
public class Iva {
    private static final double IVA_RATE = 0.12;

    public static double calculateIVA(double price) {
        return price * IVA_RATE;
    }
}
