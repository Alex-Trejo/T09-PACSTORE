package ec.edu.espe.HuertoEcoMarket.model;

/**
 *
 * @author Reishel Tipan, PACSTORE, DCCO-ESPE
 */
public class RegisterProduct {

    private String name;
    private double unitPrice;

    public RegisterProduct(String name, int amount, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public RegisterProduct() {
        name = "";
        unitPrice = 0.0d;
    }

    @Override
    public String toString() {
        return "RegisterProduct{" + "name=" + name + ", unitPrice=" + unitPrice + '}';
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
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setAmount(int amount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
