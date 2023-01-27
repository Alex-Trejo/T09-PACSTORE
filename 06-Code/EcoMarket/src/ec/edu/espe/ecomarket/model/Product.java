package ec.edu.espe.ecomarket.model;

/**
 *
 * @author Reishel Tipan, PACSTORE, DCCO-ESPE
 */
public class Product {

    private String name;
    private double unitPrice;
    private int amount;

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", unitPrice=" + unitPrice + ", amount=" + amount + '}';
    }

    public Product(String name, double unitPrice, int amount) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.amount = amount;
    }
    
    
     public Product() {
        name = "";
        unitPrice = 0.0;
        amount = 0;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

   

    

    

   

    

}
