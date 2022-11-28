package ec.edu.espe.HuertoEcoMarket.Simulator;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.HuertoEcoMarket.model.Inventory;
import ec.edu.espe.HuertoEcoMarket.model.RegisterProduct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Toapanta, Pacstore, DCCO-ESPE
 */
public class HuertoEcoMarketSimulator {

    public static void main(String[] args) {

        int option = 0;
        String name;
        int amount;
        double unitPrice;
        Boolean exit = false;
        int position = 0;
        String products = "";

        int registrationOfIncomingProducts = 0;
        ArrayList<Inventory> stock = new ArrayList<>();
        RegisterProduct register = new RegisterProduct();
        Scanner console = new Scanner(System.in);

        while (!exit) {
            HeaderOfThePresentation(registrationOfIncomingProducts);

            try {
                System.out.println("Enter the option:");
                option = console.nextInt();

                switch (option) {
                    case 1 -> {
                        int followAction = 1;
                        while (followAction == 1) {

                            saveProduct(registrationOfIncomingProducts, register, stock);

                            System.out.println("=======================================================");
                            System.out.println("Would you like to enter another product? \n Enter the number: \n(1)Yes \n(2)NO \nEnter the number:");
                            followAction = console.nextInt();
                            System.out.println("=======================================================");

                            registrationOfIncomingProducts++;

                        }
                    }

                    case 2 -> {

                        int submenuOptions = 0;
                        while (submenuOptions != 3) {
                            submenu();
                            submenuOptions = console.nextInt();

                            switch (submenuOptions) {
                                case 1 -> {

                                    int confirmation = 1;
                                    boolean validationName = true;
                                    int search = 2;
                                    int answer;
                                    int eliminateQuantity;
                                    int increaseTheQuantity;
                                    int existingAmount;
                                    int amounts;

                                    if (registrationOfIncomingProducts != 0) {
                                        while (confirmation == 1) {
                                            printList(registrationOfIncomingProducts, stock);

                                            System.out.print("Enter the number of the product you wish to modify the stock:\t");
                                            search = console.nextInt();

                                            while (search <= 0 || search > stock.size()) {
                                                System.out.println("Not registered");
                                                System.out.println("Enter again:");
                                                search = console.nextInt();
                                            }
                                            
                                            search -= 1;
                                            System.out.println("======================================");
                                            System.out.println("Select:\n(1)Do you want to eliminate stock?\n(2)Do you want to increase stock?\nEnter your answer:");
                                            answer = console.nextInt();

                                            if (answer == 1) {
                                                printSelectedProduct(stock, search);
                                                eliminateQuantity = console.nextInt();
                                                existingAmount = stock.get(search).getAmount();
                                                eliminateQuantity = checkQuantityToBeEliminated(eliminateQuantity, existingAmount, console);

                                                amounts = existingAmount - eliminateQuantity;

                                                stock.get(search).setAmount(amounts);
                                                printModified(stock, search);
                                                addJson(stock);
                                                confirmation = 2;

                                            } else if (answer == 2) {
                                                printProductIncreased(stock, search);
                                                increaseTheQuantity = console.nextInt();
                                                existingAmount = stock.get(search).getAmount();
                                                amounts = existingAmount + increaseTheQuantity;

                                                stock.get(search).setAmount(amounts);
                                                printModified(stock, search);
                                                addJson(stock);
                                                confirmation = 2;

                                            } else {
                                                System.out.println("The options are from 1 to 2");

                                            }

                                        }

                                    } else {
                                        System.out.println("No products have been registered yet");
                                    }

                                }
                                case 2 -> {
                                    if (registrationOfIncomingProducts != 0) {

                                        printAllListOfProduct(stock, position);

                                    } else {
                                        System.out.println("No prodcuts have been registered yet");

                                    }
                                }

                                case 3 -> {

                                    submenuOptions = 3;
                                    break;
                                }
                                default ->
                                    System.out.println("The options are from 1 to 3");

                            }

                        }

                    }
                    case 3 -> {
                        int itemToBeSold = 0;
                        int productSell = 0;
                        int existingAmount = 0;
                        double UnitPrice;
                        int amounts;
                        if (registrationOfIncomingProducts != 0) {
                            System.out.println("-------------------------Sales registration system-----------------");
                            System.out.println("=======================================================");
                            System.out.println("--------List of products in stock:---------");
                            System.out.println("Name\t\t\t\t  UnitPrice\t\t\t");
                            for (int i = 0; i < registrationOfIncomingProducts; i++) {

                                System.out.printf("[%d].%s \t\t\t   %.2f\t\t\t\t   \n", (i + 1), stock.get(i).getName(), stock.get(i).getUnitPrice());

                            }

                            System.out.print("Enter the item number of the item to be sold:\t");
                            itemToBeSold = console.nextInt();

                            while (itemToBeSold <= 0 || itemToBeSold > stock.size()) {
                                System.out.println("Not registered");
                                System.out.println("Enter again:");
                                itemToBeSold = console.nextInt();
                            }
                            itemToBeSold -= 1;
                            System.out.print("Enter the quantity to be sold:\t");
                            productSell = console.nextInt();//quantity of product sold
                            existingAmount = stock.get(itemToBeSold).getAmount();
                            UnitPrice = stock.get(itemToBeSold).getUnitPrice();
