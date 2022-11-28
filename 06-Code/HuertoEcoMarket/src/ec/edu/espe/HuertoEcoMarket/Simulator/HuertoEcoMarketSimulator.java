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

                            while (productSell > existingAmount) {
                                System.out.println("The quantity to be sold entered exceeds the existing quantity in stock¡¡");
                                System.out.print("Re-enter the quantity to be sold:\t");
                                productSell = console.nextInt();
                            }
                            System.out.println("==========================");
                            var multiply = productSell * UnitPrice;

                            System.out.println("Name\t\t\t\t  UnitPrice\t\t\t Total price");

                            System.out.printf("[%d].%s \t\t\t   %.2f\t\t\t\t %.2f  \n", (itemToBeSold), stock.get(itemToBeSold).getName(), stock.get(itemToBeSold).getUnitPrice(), multiply);

                            amounts = existingAmount - productSell;
                            stock.get(itemToBeSold).setAmount(amounts);
                            addJson(stock);
                        } else {
                            System.out.println("No prodcuts have been registered yet");

                        }
                    }
                    case 4 ->
                        exit = true;
                    default ->
                        System.out.println("The options are from 1 to 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("You only have to enter numbers");
                console.next();

            } catch (RuntimeException e) {
                e.printStackTrace();
            }

        }
        System.out.println("_______End of menu_________");

    }

    private static void printModified(ArrayList<Inventory> stock, int search) {
        System.out.println("-----------Modified quantity-----------");
        System.out.println("Name product:\t\t" + stock.get(search).getName());
        System.out.println("quantity in inventory:\t " + stock.get(search).getAmount());
        System.out.println("-----------Modified quantity-----------");
    }

    private static void printAllListOfProduct(ArrayList<Inventory> stock, int position) {
        System.out.println("=======================================================");
        System.out.println("--------       Inventory:      ---------");
        System.out.println("\tName\t\t\tUnitPrice\t\t\tAmount");

        for (int i = 0; i < stock.size(); i++) {

            System.out.printf("[%d].%s \t\t\t%.2f\t\t\t\t %d\n", (i + 1), stock.get(i).getName(), stock.get(i).getUnitPrice(), stock.get(i).getAmount());
            position++;

        }
    }

    private static void printProductIncreased(ArrayList<Inventory> stock, int search) {
        System.out.println("Name product:\t\t\t" + stock.get(search).getName());
        System.out.println("quantity in inventory:\t\t " + stock.get(search).getAmount());
        System.out.println("Enter the amount to be increased:\t");
    }

    private static int checkQuantityToBeEliminated(int eliminateQuantity, int existingAmount, Scanner console) {
        while (eliminateQuantity > existingAmount) {
            System.out.println("The quantity to be removed entered exceeds the existing quantity in stock¡¡");
            System.out.print("Re-enter the quantity to be deleted:\t");
            eliminateQuantity = console.nextInt();

        }
        return eliminateQuantity;
    }

    private static void printSelectedProduct(ArrayList<Inventory> stock, int search) {
        System.out.println("Name product:\t\t\t" + stock.get(search).getName());
        System.out.println("quantity in inventory:\t\t " + stock.get(search).getAmount());
        System.out.println("Enter the quantity to be removed:\t");
    }

    private static void printList(int registrationOfIncomingProducts, ArrayList<Inventory> stock) {
        String products;
        System.out.println("=======================================================");
        System.out.println("--------List of products in stock:---------");
        System.out.println("Name\t\t\t\t  UnitPrice\t\t\tAmount");
        for (int i = 0; i < registrationOfIncomingProducts; i++) {
            products = stock.get(i).getName();
            System.out.printf("[%d].%s \t\t\t   %.2f\t\t\t\t   %d\n", (i + 1), stock.get(i).getName(), stock.get(i).getUnitPrice(), stock.get(i).getAmount());

        }
    }

    private static void submenu() {
        System.out.println("____________Welcome to Inventory_________");
        System.out.println("1.Eliminate/increase stock of a product");
        System.out.println("2.Show products and stock");
        System.out.println("3.Exit");
        System.out.print("Type an option:\t");
    }

    private static void saveProduct(int registrationOfIncomingProducts, RegisterProduct register, ArrayList<Inventory> stock) {
        Inventory products = new Inventory();

        String name = "";
        int amount = 0;
        double unitPrice = 0.0;

        System.out.println("__________________Product registration system______________");
        System.out.println("----------------------------Product" + (registrationOfIncomingProducts + 1) + "----------------");
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the name of the Product to register:\t\t");
            name = scanner.nextLine();

            System.out.print("Enter the number of boxes:\t");
            amount = scanner.nextInt();

            System.out.print("Enter the unit price:\t");
            unitPrice = Double.parseDouble(scanner.next());
        } catch (Exception er) {
            System.out.println("Data type does not match ");
        }

        register.setName(name);
        products.setName(name);
        register.setAmount(amount);
        products.setAmount(amount);
        register.setUnitPrice(unitPrice);
        products.setUnitPrice(unitPrice);
        stock.add(products);
        addJson(stock);
    }

    private static void HeaderOfThePresentation(int position) {
        if (position == 0) {
            System.out.println("       UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE       ");
            System.out.println("                       Project");
            System.out.println("                  HUERTO ECO-MARKET\n");
            System.out.println("      Integrantes:\n\t\t\tReishel Tipan\n" + "\t\t\tDavid Toapanta\n" + "\t\t\tCarlos Torres\n" + "\t\t\tAlex Trejo\n");

            System.out.println("Instructor: Edison Lascano");
            System.out.println("=========================================================");
            System.out.println("¡WELCOME TO CHICKEN FARM SIMULATOR :)!       ");
            System.out.println("______________________________________________________________");
        }

        System.out.println("_____________Menu________________");
        System.out.println("1)Register products:");
        System.out.println("2)Inventory:");
        System.out.println("3)Sale:");
        System.out.println("4)Log out");

    }

    private static void addJson(ArrayList<Inventory> stock) {
        String save = new Gson().toJson(stock);
        try {
            FileWriter write = new FileWriter("HuertoEcoMarket.json");
            write.write(save);
            write.close();

        } catch (IOException ex) {
            Logger.getLogger(HuertoEcoMarketSimulator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static ArrayList<Inventory> readJSON(ArrayList<Inventory> stocks) throws JsonSyntaxException {
        String json = "";
        Gson gson = new Gson();
        //
        try {
            BufferedReader br = new BufferedReader(new FileReader("HuertoEcoMarket.json"));
            String line = "";
            while ((line = br.readLine()) != null) {
                json = line;
                TypeToken<ArrayList<Inventory>> types = new TypeToken<ArrayList<Inventory>>() {
                };

            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HuertoEcoMarketSimulator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HuertoEcoMarketSimulator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stocks;
    }
}
