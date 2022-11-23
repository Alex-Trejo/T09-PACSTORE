package ec.edu.espe.HuertoEcoMarket.model;
/**
 *
 * @author David Toapanta, Pacstore, DCCO-ESPE
 */
public class ProductList {
    private String name;
    private double productPrice;
    private int idProduct;

    @Override
    public String toString() {
        return "ProductList{" + "name=" + name + ", productPrice=" + productPrice + ", idProduct=" + idProduct + '}';
    }
    

    public ProductList(String name, double productPrice, int idProduct) {
        this.name = name;
        this.productPrice = productPrice;
        this.idProduct = idProduct;
    }
    
    public ProductList(){
        this.name = "";
        this.productPrice = 0.0;
        this.idProduct = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
    
    
}
