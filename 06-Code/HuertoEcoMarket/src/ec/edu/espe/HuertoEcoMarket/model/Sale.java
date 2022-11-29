/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.HuertoEcoMarket.model;

/**
 *
 * @author Reishel Tipan, PACSTORE, DCCO-ESPE
 */
public class Sale {

    private String name;
    private int amount;
    private double unitPrice;
    private double fullValue;

    @Override
    public String toString() {
        return "Sale{" + "name=" + name + ", amount=" + amount + ", unitPrice=" + unitPrice + ", fullValue=" + fullValue + '}';
    }
    public Sale() {
        this.unitPrice = 0.0;
        this.name = "";
        this.fullValue = 0.0;
    }

    public Sale(String name, int amount, double unitPrice, double fullValue) {
        this.name = name;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.fullValue = fullValue;
    }
    
    
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getFullValue() {
        return fullValue;
    }

    public void setFullValue(double fullValue) {
        this.fullValue = fullValue;
    }

    
    
    
    
    
    
    
    
    
    
    

    public void totalAmount() {
        double result = unitPrice + fullValue;
        System.out.println("The total purchase price is:" + result);

    }
}
