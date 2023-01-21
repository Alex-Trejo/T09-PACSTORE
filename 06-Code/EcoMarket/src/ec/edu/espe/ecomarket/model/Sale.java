
package ec.edu.espe.ecomarket.model;

/**
 *
 * @author Alex Trejo, PACSTORE, DCCO-ESPE
 */
public class Sale {
    private String nameOfProduct;
    private int amountOfProductSold;
    private double unitPrice;
    private double totalMoney;

    @Override
    public String toString() {
        return "Sale{" + "nameOfProduct=" + nameOfProduct + ", amountOfProductSold=" + amountOfProductSold + ", unitPrice=" + unitPrice + ", totalMoney=" + totalMoney + '}';
    }

    public Sale(String nameOfProduct, int amountOfProductSold, double unitPrice, double totalMoney) {
        this.nameOfProduct = nameOfProduct;
        this.amountOfProductSold = amountOfProductSold;
        this.unitPrice = unitPrice;
        this.totalMoney = totalMoney;
    }

    public Sale() {
        nameOfProduct = "";
        amountOfProductSold = 0;
        unitPrice = 0.0;
        totalMoney = 0.0;
    }
    
    
    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public int getAmountOfProductSold() {
        return amountOfProductSold;
    }

    public void setAmountOfProductSold(int amountOfProductSold) {
        this.amountOfProductSold = amountOfProductSold;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

   
    
}
