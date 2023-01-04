package ec.edu.espe.HuertoEcoMarket.Simulator;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.HuertoEcoMarket.model.Inventory;
import ec.edu.espe.HuertoEcoMarket.model.Product;
import ec.edu.espe.HuertoEcoMarket.model.Sale;
import java.io.BufferedReader;
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
        ArrayList<Product> register = new ArrayList<>();
        ArrayList<Sale> sale = new ArrayList<>();
        Sale saleRecord = new Sale();
        
       
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

                            followAction = registerMoreProducts(console);

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

                                            search = compareQuantityInStock(search, stock, console);

                                            search -= 1;
                                            System.out.println("=======================================================");
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
                                                addJsonInventary(stock);
                                                confirmation = 2;

                                            } else if (answer == 2) {
                                                printProductIncreased(stock, search);
                                                increaseTheQuantity = console.nextInt();
                                                existingAmount = stock.get(search).getAmount();
                                                amounts = existingAmount + increaseTheQuantity;

                                                stock.get(search).setAmount(amounts);
                                                printModified(stock, search);
                                                addJsonInventary(stock);
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
                                    int numberOfProducts; 
                                    ArrayList<Inventory> inventoryRead=new ArrayList<>();
                                    ArrayList<Product> productRead= new ArrayList<>();
                                    inventoryRead=readJSONInventory(inventoryRead);
                                    productRead=readJSONProduct(productRead);
                                    numberOfProducts=inventoryRead.size();
                                    
                                    if (numberOfProducts != 0) {
                                       
                                        printAllListOfProduct(inventoryRead, position, productRead);

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
                        String nameProductSale;
                        int amounts;
                        if (registrationOfIncomingProducts != 0) {
                            productListingForSale(registrationOfIncomingProducts, register);

                            System.out.print("Enter the item number of the item to be sold:\t");
                            itemToBeSold = console.nextInt();

                            itemToBeSold = compareQuantityInStock(itemToBeSold, stock, console);
                            itemToBeSold -= 1;
                            nameProductSale = stock.get(itemToBeSold).getName();
                            System.out.print("Enter the quantity to be sold:\t");
                            productSell = console.nextInt();//quantity of product sold
                            existingAmount = stock.get(itemToBeSold).getAmount();
                            UnitPrice = register.get(itemToBeSold).getUnitPrice();

                            productSell = checkStock (productSell, existingAmount, console);
                            System.out.println("=======================================================");
                            var multiply = productSell * UnitPrice;

                            System.out.println("Name\t\t\t\t  UnitPrice\t\t\t Total price");

                            System.out.printf("[%d].%s \t\t\t   %.2f\t\t\t\t %.2f  \n", (itemToBeSold), stock.get(itemToBeSold).getName(), register.get(itemToBeSold).getUnitPrice(), multiply);

                            amounts = existingAmount - productSell;
                            stock.get(itemToBeSold).setAmount(amounts);
                            addJsonInventary(stock);
                            saleRecord.setName(nameProductSale);
                            saleRecord.setAmount(productSell);
                            saleRecord.setUnitPrice(UnitPrice);
                            saleRecord.setFullValue(multiply);

                            sale.add(saleRecord);

                            addJsonSale(sale);

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
                System.out.println("=======================================================");

            } catch (RuntimeException e) {
                e.printStackTrace();
            }

        }
        System.out.println("___________________End of menu_____________________");

    }

    private static int checkStock (int productSell, int existingAmount, Scanner console) {
        while (productSell > existingAmount) {
            System.out.println("The quantity to be sold entered exceeds the existing quantity in stock¡¡");
            System.out.print("Re-enter the quantity to be sold:\t");
            productSell = console.nextInt();
        }
        return productSell;
    }

    private static void productListingForSale(int registrationOfIncomingProducts, ArrayList<Product> register) {
        System.out.println("--------------Sales registration system----------------");
        System.out.println("=======================================================");
        System.out.println("---------------List of products in stock:--------------");
        System.out.println("Name\t\t\t\t  UnitPrice\t\t\t");
        for (int i = 0; i < registrationOfIncomingProducts; i++) {
            
            System.out.printf("[%d].%s \t\t\t   %.2f\t\t\t\t   \n", (i + 1), register.get(i).getName(), register.get(i).getUnitPrice());
            
        }
    }

    private static int compareQuantityInStock(int search, ArrayList<Inventory> stock, Scanner console) {
        while (search <= 0 || search > stock.size()) {
            System.out.println("Not registered");
            System.out.println("Enter again:");
            search = console.nextInt();
        }
        return search;
    }

    private static int registerMoreProducts(Scanner console) {
        int followAction;
        System.out.println("=======================================================");
        System.out.println("Would you like to enter another product? \n Enter the number: \n(1)Yes \n(2)NO \nEnter the number:");
        followAction = console.nextInt();
        System.out.println("=======================================================");
        return followAction;
    }

    private static void printModified(ArrayList<Inventory> stock, int search) {
        System.out.println("-----------Modified quantity-----------");
        System.out.println("Name product:\t\t" + stock.get(search).getName());
        System.out.println("quantity in inventory:\t " + stock.get(search).getAmount());
        System.out.println("-----------Modified quantity-----------");
    }

    private static void printAllListOfProduct(ArrayList<Inventory> stock, int position, ArrayList<Product> register) {
        System.out.println("=======================================================");
        System.out.println("----------------------Inventory------------------------");
        System.out.println("\tName\t\t\tUnitPrice\t\t\tAmount");

        for (int i = 0; i < stock.size(); i++) {

            System.out.printf("[%d].%s \t\t\t%.2f\t\t\t\t %d\n", (i + 1), stock.get(i).getName(), register.get(i).getUnitPrice(), stock.get(i).getAmount());
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

        System.out.println("=======================================================");
        System.out.println("----------------List of products in stock:-------------");
        System.out.println("Name\t\t\t\t Amount");
        for (int i = 0; i < registrationOfIncomingProducts; i++) {

            System.out.printf("[%d].%s \t\t\t   %d\n", (i + 1), stock.get(i).getName(), stock.get(i).getAmount());

        }
    }

    private static void submenu() {
        System.out.println("------------------Welcome to Inventory-----------------");
        System.out.println("  1.Eliminate/increase stock of a product");
        System.out.println("  2.Show products and stock");
        System.out.println("  3.Exit");
        System.out.print("  Type an option:\t");
    }

    private static void saveProduct(int registrationOfIncomingProducts, ArrayList<Product> register, ArrayList<Inventory> stock) {
        Product enteredProduct = new Product();
        Inventory products = new Inventory();

        String name = "";
        int amount = 0;
        double unitPrice = 0.0;
        
        System.out.println("=======================================================");
        System.out.println("______________Product registration system______________");
        System.out.println("-----------------------Product" + (registrationOfIncomingProducts + 1) + "-----------------------");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the Product to register:\t\t");
        name = scanner.nextLine();

        System.out.print("Enter the number of boxes:\t");
        amount = scanner.nextInt();

        System.out.print("Enter the unit price:\t");
        unitPrice = Double.parseDouble(scanner.next());

        enteredProduct.setName(name);
        products.setName(name);

        products.setAmount(amount);
        enteredProduct.setUnitPrice(unitPrice);

        stock.add(products);
        register.add(enteredProduct);
        addJsonRegisterProduct(register);
        addJsonInventary(stock);
    }

    private static void HeaderOfThePresentation(int position) {
        if (position == 0) {
            System.out.println("       UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE       ");
            System.out.println("                       Project");
            System.out.println("                  HUERTO ECO-MARKET\n");
            System.out.println("      Integrantes:\n\t\t\tReishel Tipan\n" + "\t\t\tDavid Toapanta\n" + "\t\t\tCarlos Torres\n" + "\t\t\tAlex Trejo\n");

            System.out.println("Instructor: Edison Lascano");
            System.out.println("=========================================================");
            System.out.println("       ¡WELCOME TO HUERTO ECO MARKET INVENTORY :)!       ");
            System.out.println("_________________________________________________________");
            System.out.println("=========================================================");

        }

        System.out.println("-------------------------Menu--------------------------");
        System.out.println("1)Register products:");
        System.out.println("2)Inventory:");
        System.out.println("3)Sale:");
        System.out.println("4)Log out");

    }

    private static void addJsonInventary(ArrayList<Inventory> stock) {
        String save = new Gson().toJson(stock);
        try {
            try ( FileWriter write = new FileWriter("Inventary.json")) {
                write.write(save);
                write.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(HuertoEcoMarketSimulator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void addJsonRegisterProduct(ArrayList<Product> register) {
        String save = new Gson().toJson(register);

        try {
            try ( FileWriter write = new FileWriter("RegisterProduct.json")) {
                write.write(save);
                write.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(HuertoEcoMarketSimulator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void addJsonSale(ArrayList<Sale> sale) {
        String save = new Gson().toJson(sale);
        try {
            try ( FileWriter write = new FileWriter("Sale.json")) {
                write.write(save);
                write.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(HuertoEcoMarketSimulator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static ArrayList<Inventory> readJSONInventory(ArrayList<Inventory> stocks) throws JsonSyntaxException {
        String json = "";
        Gson gson = new Gson();

        try {
            BufferedReader br = new BufferedReader(new FileReader("Inventary.json"));
            String line = "";
            while ((line = br.readLine()) != null) {
                json = line;
                TypeToken<ArrayList<Inventory>> types = new TypeToken<ArrayList<Inventory>>() {
                };

                stocks = gson.fromJson(json, types.getType());

            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HuertoEcoMarketSimulator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HuertoEcoMarketSimulator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stocks;
    }
    
    private static ArrayList<Product> readJSONProduct(ArrayList<Product> register) throws JsonSyntaxException {
        String json = "";
        Gson gson = new Gson();

        try {
            BufferedReader br = new BufferedReader(new FileReader("RegisterProduct.json"));
            String line = "";
            while ((line = br.readLine()) != null) {
                json = line;
                TypeToken<ArrayList<Product>> types = new TypeToken<ArrayList<Product>>() {
                };

                register = gson.fromJson(json, types.getType());

            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HuertoEcoMarketSimulator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HuertoEcoMarketSimulator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return register;
    }
    
    
}
