/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.HuertoEcoMarket.model;

import java.util.ArrayList;

/**
 *
 * @author Reishel Tipan, PACSTORE, DCCO-ESPE
 */
public class Inventory {

    private ArrayList<RegisterProduct> listProduct = new ArrayList<>();

    RegisterProduct registerEntered = new RegisterProduct();

    public ArrayList<RegisterProduct> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<RegisterProduct> listProduct) {
        this.listProduct = listProduct;
    }

    public void Remove() {
        listProduct.remove(registerEntered);
        System.out.printf("The product %s has been successfully removed. ",registerEntered.getName());
    }

    @Override
    public String toString() {
        System.out.println("________________________The list of products entered________________________");
        return "Inventory{" + "listProduct=" + listProduct + '}';
    }

}
