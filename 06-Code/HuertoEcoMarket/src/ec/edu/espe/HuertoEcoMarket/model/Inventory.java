package ec.edu.espe.HuertoEcoMarket.model;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Reishel Tipan, PACSTORE, DCCO-ESPE
 */
public class Inventory {

    private String name;
    private int amount;

    public Inventory() {
        name = "";
        amount = 0;

    }

    public Inventory(String name, int amount, double unitPrice) {
        this.name = name;
        this.amount = amount;

    }

    @Override
    public String toString() {
        return "Inventory{" + "name=" + name + ", amount=" + amount + '}';
    }

   

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }


}
