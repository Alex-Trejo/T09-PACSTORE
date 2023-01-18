package ec.edu.espe.ecomarket.controller;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import ec.edu.espe.ecomarket.model.Customer;
import ec.edu.espe.ecomarket.model.EmailCustomer;
import ec.edu.espe.ecomarket.model.Employee;
import ec.edu.espe.ecomarket.model.IdCustomer;
import ec.edu.espe.ecomarket.model.Inventory;
import ec.edu.espe.ecomarket.model.Manager;
import ec.edu.espe.ecomarket.model.Product;
import ec.edu.espe.ecomarket.model.Sale;
import ec.edu.espe.ecomarket.view.EcoMarket;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Alex Trejo, PACSTORE, DCCO-ESPE
 */
public class FileManager {

    private static final Scanner scanner = new Scanner(System.in);

    public static void newMenu() {

        System.out.println("       UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE       ");
        System.out.println("                       Project");
        System.out.println("                  HUERTO ECO-MARKET\n");
        System.out.println("      Integrantes:\n\t\t\tReishel Tipan\n" + "\t\t\tDavid Toapanta\n" + "\t\t\tCarlos Torres\n" + "\t\t\tAlex Trejo\n");

        System.out.println("Instructor: Edison Lascano");
        System.out.println("=========================================================");
        System.out.println("       ¡WELCOME TO HUERTO ECO MARKET INVENTORY :)!       ");
        System.out.println("_________________________________________________________");
        System.out.println("=========================================================");

        System.out.println("______________Login_________________");
        System.out.println("1.Manager");
        System.out.println("2.Employee");
        System.out.println("3.Exit");

    }//

    public static Manager userLogin() {
        String userName;
        String password;
        Manager manager = new Manager();
        System.out.println("==========================================================");
        System.out.println("_______________User login_______________");
        System.out.print("Enter your username:\t");
        userName = scanner.next();
        System.out.print("Enter your password:\t");
        password = scanner.next();

        manager.setUserName(userName);
        manager.setPassword(password);

        return manager;

    }//

    public static int reenterManagerData(int state) {
        Manager manager;
        while (state == 0) {
            System.out.println("______________________________________");
            System.out.println("Re-enter the data ");
            manager = FileManager.userLogin();
            state = FileManager.validateUserManager(manager);
        }
        return state;
    }//

    public static int validateUserManager(Manager manager) {

        String uri = "mongodb+srv://alextrejo:1402oop@cluster0.ydafxco.mongodb.net/?retryWrites=true&w=majority";
        String userName;
        int state = 0;
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("T09-PACSTORE");
            try {

                MongoCollection<Document> managerCollection = database.getCollection("Manager");
                userName = manager.getUserName();

                Bson filter = Filters.eq("user_name", userName);
                try {
                    Document doc = managerCollection.find(Filters.and(filter)).first();

                    userName = doc.getString("user_name");
                    state = 1;
                    return state;

                } catch (Exception e) {
                    System.out.println("Data not found");
                    state = 0;

                }

            } catch (MongoException me) {
                me.getMessage();

            }
        }

        return state;

    }//

    public static Employee userLoginEmployee() {
        String userName;
        String password;
        Employee employee = new Employee();
        System.out.println("==========================================================");
        System.out.println("_______________User login_______________");
        System.out.print("Enter your username:\t");
        userName = scanner.next();
        System.out.print("Enter your password:\t");
        password = scanner.next();

        employee.setUserName(userName);
        employee.setPassword(password);

        return employee;

    }//

    public static Employee reenterEmployeeData(int state) {
        Employee employee= new Employee();
        while (state == 0) {
            System.out.println("______________________________________");
            System.out.println("Re-enter the data ");
            employee = userLoginEmployee();
            state = validateUserEmployee(employee);
        }

        return employee;

    }//

    public static int validateUserEmployee(Employee employee) {

        String uri = "mongodb+srv://alextrejo:1402oop@cluster0.ydafxco.mongodb.net/?retryWrites=true&w=majority";
        String userName;
        int state = 0;
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("T09-PACSTORE");
            try {

                MongoCollection<Document> managerCollection = database.getCollection("Employee");
                userName = employee.getUserName();

                Bson filter = Filters.eq("user_name", userName);
                try {
                    Document doc = managerCollection.find(Filters.and(filter)).first();

                    userName = doc.getString("user_name");
                    state = 1;
                    return state;

                } catch (Exception e) {
                    System.out.println("Data not found");
                    state = 0;

                }

            } catch (MongoException me) {
                me.getMessage();

            }
        }

        return state;

    }//

    public static void actionsOfTheManager() {

        System.out.println("-------------------------Menu--------------------------");
        System.out.println("1)Register products:");
        System.out.println("2)Inventory");
        System.out.println("3)Sale Record");
        System.out.println("4)Employee System");
        System.out.println("5)Log out");

    }//

    public static void actionsOfTheEmployee() {
        System.out.println("--------------------------Manu------------------------");
        System.out.println("1)Sale");
        System.out.println("2)Inventory");
        System.out.println("3)Exit");

    }//

    public static void viewProduct() {
        int option;

        Boolean exit = false;

        String uri = "mongodb+srv://alextrejo:1402oop@cluster0.ydafxco.mongodb.net/?retryWrites=true&w=majority";
        System.out.println("___________________________________________________________________________________________");
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("T09-PACSTORE");
            try {
                System.out.println("The connection to the EcoMarketS database was successful.");
                System.out.println("_________________________________________________________________________________________");
                MongoCollection<Document> productCollection = database.getCollection("Product");
                option = subMenu();
                while (!exit) {
                    switch (option) {
                        case 1 -> {
                            Boolean answerUser;
                            answerUser = oneProduct(productCollection, database);
                            exit = answerUser;
                            exit = true;

                        }
                        case 2 -> {
                            exit = printAllProducts(productCollection);

                        }

                        case 3 ->
                            exit = true;

                        default -> {
                            System.out.println("The options are from 1 to 3");
                            exit = true;
                        }

                    }

                }

            } catch (MongoException me) {
                System.out.println("An error occurred while attempting to connect: " + me);
            }
        }
    }//

    public static void viewProductEmployee() {
        int option;
        String name;
        Boolean exit = false;
        int answer;

        String uri = "mongodb+srv://alextrejo:1402oop@cluster0.ydafxco.mongodb.net/?retryWrites=true&w=majority";
        System.out.println("___________________________________________________________________________________________");
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("T09-PACSTORE");
            try {
                System.out.println("The connection to the EcoMarketS database was successful.");
                System.out.println("_________________________________________________________________________________________");
                MongoCollection<Document> productCollection = database.getCollection("Product");

                printAllProducts(productCollection);

            } catch (MongoException me) {
                System.out.println("An error occurred while attempting to connect: " + me);
            }
        }
    }//

    public static void updateData() {
        int reply;
        String name;
        String nameNew;
        double unitPriceNew;
        Boolean exit = false;
        Product enteredProduct = new Product();

        String uri = "mongodb+srv://alextrejo:1402oop@cluster0.ydafxco.mongodb.net/?retryWrites=true&w=majority";
        System.out.println("___________________________________________________________________________________________");
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("T09-PACSTORE");
            try {

                System.out.println("The connection to the EcoMarketS database was successful.");
                System.out.println("_________________________________________________________________________________________");
                MongoCollection<Document> productCollection = database.getCollection("Product");
                MongoCollection<Document> inventoryCollection = database.getCollection("Inventory");

                reply = subMenuUpdate();

                reply = validateUpdate(reply);

                while (!exit) {
                    switch (reply) {
                        case 1 -> {
                            updateAllProduct(productCollection, inventoryCollection, enteredProduct);

                            exit = true;

                        }
                        case 2 -> {
                            reply = updateOnlyOne(productCollection, inventoryCollection, reply);

                            exit = true;
                        }
                        case 3 -> {
                            exit = true;
                        }
                        default -> {
                            System.out.println("You can only select from 1 to 3");
                            exit = true;
                        }

                    }
                }

            } catch (MongoException me) {
                System.out.println("An error occurred while attempting to connect: " + me);
            }

        }
    }//

    public static void saleProductManager(Manager manager) {

        int addAnotherProduct = 1;
        String uri = "mongodb+srv://alextrejo:1402oop@cluster0.ydafxco.mongodb.net/?retryWrites=true&w=majority";
        System.out.println("___________________________________________________________________________________________");
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("T09-PACSTORE");
            try {

                System.out.println("The connection to the EcoMarketS database was successful.");
                System.out.println("_________________________________________________________________________________________");
                MongoCollection<Document> productCollection = database.getCollection("Product");
                MongoCollection<Document> salesRecordCollection = database.getCollection("SalesRecord");
                MongoCollection<Document> inventoryCollection = database.getCollection("Inventory");
                MongoCollection<Document> customerCollection = database.getCollection("Customer");
                Sale sale = new Sale();

                printAllProducts(productCollection);

                while (addAnotherProduct == 1) {

                    registerSale(productCollection, sale, salesRecordCollection, inventoryCollection, customerCollection, manager.getName());

                    addAnotherProduct = moreSale();
                }

            } catch (MongoException me) {
                System.out.println("An error occurred while attempting to connect: " + me);
            }
        }
    }//

    public static void saleProductEmployee(String name) {

        int addAnotherProduct = 1;
        String uri = "mongodb+srv://alextrejo:1402oop@cluster0.ydafxco.mongodb.net/?retryWrites=true&w=majority";
        System.out.println("___________________________________________________________________________________________");
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("T09-PACSTORE");
            try {

                System.out.println("The connection to the EcoMarketS database was successful.");
                System.out.println("_________________________________________________________________________________________");
                MongoCollection<Document> productCollection = database.getCollection("Product");
                MongoCollection<Document> salesRecordCollection = database.getCollection("SalesRecord");
                MongoCollection<Document> inventoryCollection = database.getCollection("Inventory");
                MongoCollection<Document> customerCollection = database.getCollection("Customer");
                Sale sale = new Sale();

                printAllProducts(productCollection);
                System.out.println("name--->"+name);

                while (addAnotherProduct == 1) {

                    registerSale(productCollection, sale, salesRecordCollection, inventoryCollection, customerCollection, name);

                    addAnotherProduct = moreSale();
                }

            } catch (MongoException me) {
                System.out.println("An error occurred while attempting to connect: " + me);
            }
        }
    }//

    private static int moreSale() {
        int addAnotherProduct;
        System.out.println("=======================================================");
        System.out.println("Would you like to enter another product? \n Enter the number: \n(1)Yes \n(2)NO \nEnter the number:");
        addAnotherProduct = scanner.nextInt();
        System.out.println("=======================================================");
        return addAnotherProduct;
    }//

    private static void registerSale(MongoCollection<Document> productCollection, Sale sale, MongoCollection<Document> salesRecordCollection, MongoCollection<Document> inventoryCollection, MongoCollection<Document> customerCollection, String name) {
        String nameProductSell;
        Customer customer = new Customer();

        int quantity;
        double unitPrice;
        int registeredQuantity;
        double totalMoney;
        boolean validateId = false;
        boolean validateEmailEntered = false;

        System.out.println("name__>"+name);
        System.out.print("Enter the name of the customer:\t");
        customer.setNameOfClient(scanner.next());
        //System.out.println("Numero de veces que ha venido");
        System.out.print("Enter of ID:\t");
        customer.setIdCustomer(scanner.next());

        validateId = IdCustomer.validateID(customer.getIdCustomer());

        while (validateId == false) {

            System.out.print("The entered ID is incorrect, please enter again:\t");
            customer.setIdCustomer(scanner.next());
            validateId = IdCustomer.validateID(customer.getIdCustomer());

        }

        System.out.print("Enter of email:\t");
        customer.setEmail(scanner.next());

        validateEmailEntered = EmailCustomer.validateEmail(customer.getEmail());

        while (validateEmailEntered == false) {

            System.out.print("The email is incorrect, please enter again:\t");
            customer.setEmail(scanner.next());
            validateEmailEntered = EmailCustomer.validateEmail(customer.getEmail());
        }

        System.out.print("Enter the name of the product to sell:\t");
        nameProductSell = scanner.next();
        System.out.print("Enter the quantity to sell:\t");
        quantity = scanner.nextInt();
        System.out.println("___________________________________________________");

        Bson filterCustomer = Filters.eq("name of customer", customer.getNameOfClient());

        Bson filter = Filters.eq("name of Product", nameProductSell);

        Document doc = productCollection.find(Filters.and(filter)).first();
        unitPrice = doc.getDouble("unit price");
        registeredQuantity = doc.getInteger("amount", quantity);
        while (quantity > registeredQuantity) {
            System.out.println("The quantity to be sold entered exceeds the existing quantity in stock¡¡");
            System.out.print("Re-enter the quantity to be sold:\t");
            quantity = scanner.nextInt();
        }
        totalMoney = (quantity * unitPrice);
        System.out.println("total___>" + totalMoney);
        sale.setNameOfProduct(nameProductSell);
        sale.setAmountOfProductSold(quantity);
        sale.setTotalMoney(totalMoney);

        if (customerCollection.find(filterCustomer).first() == null) {
            customer.setNumberOfTimesHeHasCome(1);

            Document customerNew = new Document("_id", new ObjectId())
                    .append("name of customer", customer.getNameOfClient())
                    .append("id", customer.getIdCustomer())
                    .append("number Of Times He Has Come", customer.getNumberOfTimesHeHasCome())
                    .append("email", customer.getEmail());

            customerCollection.insertOne(customerNew);

        }

        if (customerCollection.find(filterCustomer).first() != null) {

            Bson updateCustomer = Updates.inc("number Of Times He Has Come", +1);

            customerCollection.updateOne(filterCustomer, updateCustomer);

            System.out.println("The sale has been registered");

        }

        if (salesRecordCollection.find(filter).first() == null) {
            Document saleProduct = new Document("_id", new ObjectId())
                    /*.append("name of Product", sale.getNameOfProduct())
                    .append("amount sold", sale.getAmountOfProductSold())
                    .append("unit price", sale.getTotalMoney());*/
                    .append("name of employeed", name)
                    .append("name of Product", doc.get("name of Product"))
                    .append("amount sold", sale.getAmountOfProductSold())
                    .append("unit price", doc.getDouble("unit price"))
                    .append("total Money", sale.getTotalMoney());

            salesRecordCollection.insertOne(saleProduct);

            Bson updateAmount = Updates.inc("amount", -quantity);
            productCollection.updateOne(filter, updateAmount);
            inventoryCollection.updateOne(filter, updateAmount);
            System.out.println("The sale has been registered");

        } else if (salesRecordCollection.find(filter).first() != null) {

            Bson updateAmount = Updates.inc("amount sold", +quantity);
            Bson updateTotalMoney = Updates.inc("total Money", +sale.getTotalMoney());

            salesRecordCollection.updateOne(filter, updateAmount);
            salesRecordCollection.updateOne(filter, updateTotalMoney);
            Bson updateAmount2 = Updates.inc("amount", -quantity);
            productCollection.updateOne(filter, updateAmount2);
            inventoryCollection.updateOne(filter, updateAmount2);

            System.out.println("The sale has been registered");

        }
    }//

    private static int updateOnlyOne(MongoCollection<Document> productCollection, MongoCollection<Document> inventoryCollection, int reply) throws NumberFormatException {//
        String name;
        Boolean exit;
        int answer;
        name = answerOfUser(productCollection);
        Bson filter = Filters.eq("name of Product", name);
        printProdcutSelected(productCollection, filter);
        reply = updateOneProduct(reply, productCollection, inventoryCollection, filter);
        return reply;
    }//

    private static int updateOneProduct(int reply, MongoCollection<Document> productCollection, MongoCollection<Document> inventoryCollection, Bson filter) throws NumberFormatException {
        int answer;
        Boolean exit;
        System.out.print("1)Modify name\n" + "2)Change unit price\n" + "3)Change amount\n" + "3)Exit\n" + "Your answer:\t");
        answer = scanner.nextInt();

        validateUpdate(answer);

        if (answer == 1) {
            updateByName(productCollection, inventoryCollection, filter);
            exit = true;

        } else if (answer == 2) {
            updateUnitPrice(productCollection, inventoryCollection, filter);
            exit = true;

        } else if (answer == 3) {
            updateByAmount(productCollection, inventoryCollection, filter);

        }
        return reply;
    }//

    private static void updateByAmount(MongoCollection<Document> productCollection, MongoCollection<Document> inventoryCollection, Bson filter) {

        int amountNew;
        System.out.println("_____________________________");
        System.out.print("Enter the new amount:\t");
        amountNew = scanner.nextInt();
        Bson updateAmount = Updates.set("amount", amountNew);
        productCollection.updateOne(filter, updateAmount);
        inventoryCollection.updateOne(filter, updateAmount);
        System.out.println("Data has been updated");
    }//

    private static void updateByName(MongoCollection<Document> productCollection, MongoCollection<Document> inventoryCollection, Bson filter) {
        String nameOfProductNew;
        System.out.println("_____________________________________");
        System.out.print("Enter the new name:\t");
        nameOfProductNew = scanner.next();

        Bson updateName = Updates.set("name of Product", nameOfProductNew);
        productCollection.updateOne(filter, updateName);
        inventoryCollection.updateOne(filter, updateName);
        System.out.println("Data has been updated");
    }//

    private static void updateUnitPrice(MongoCollection<Document> productCollection, MongoCollection<Document> inventoryCollection, Bson filter) throws NumberFormatException {
        double unitPriceOfProductNew;
        System.out.println("_____________________________________");
        System.out.print("Enter the new unit price:\t");
        unitPriceOfProductNew = Double.parseDouble(scanner.next());

        Bson updateUnitPrice = Updates.set("unit price", unitPriceOfProductNew);

        productCollection.updateOne(filter, updateUnitPrice);
        //inventoryCollection.updateOne(filter, updateUnitPrice);
        System.out.println("Data has been updated");
    }//

    private static String answerOfUser(MongoCollection<Document> productCollection) {
        String name;
        System.out.println("__________________________________________________________________");
        printAllProducts(productCollection);
        System.out.println("______________________________________________________________________");
        System.out.print("Enter the name of the product to update:\t");
        name = scanner.next();
        return name;
    }//

    private static void printProdcutSelected(MongoCollection<Document> productCollection, Bson filter) {
        try {
            Document doc = productCollection.find(Filters.and(filter)).first();
            System.out.println("product->" + doc.toJson());

        } catch (Exception e) {
            System.out.println("Data not found");
        }
    }//

    private static void updateAllProduct(MongoCollection<Document> productCollection, MongoCollection<Document> inventoryCollection, Product enteredProduct) throws NumberFormatException {
        String name;
        String nameNew;
        double unitPriceNew;
        int amount;

        System.out.println("____________________________________________________________________");
        printAllProducts(productCollection);
        System.out.println("______________________________________________________________________");
        scanner.nextLine();
        System.out.print("Enter the name of the product to update:\t");
        name = scanner.next();
        scanner.nextLine();
        Bson filter = Filters.eq("name of Product", name);
        System.out.println("________________________________________________________________");
        System.out.print("Enter the new product name:\t");
        nameNew = scanner.next();
        System.out.print("Enter the new unit price:\t");
        unitPriceNew = Double.parseDouble(scanner.next());
        System.out.print("Enter the new amount:\t");
        amount = scanner.nextInt();
        enteredProduct.setName(nameNew);
        enteredProduct.setUnitPrice(unitPriceNew);
        enteredProduct.setAmount(amount);
        Bson productUpdate = Updates.combine(
                Updates.set("name of Product", enteredProduct.getName()),
                Updates.set("amount", enteredProduct.getAmount()),
                Updates.set("unit price", enteredProduct.getUnitPrice()));
        Bson inventoryUpdate = Updates.combine(
                Updates.set("name of Product", enteredProduct.getName()),
                Updates.set("amount", enteredProduct.getAmount()));

        productCollection.updateOne(filter, productUpdate);
        inventoryCollection.updateOne(filter, inventoryUpdate);

        System.out.println("Data has been updated");
    }//

    private static int subMenuUpdate() {
        int reply;
        System.out.print("1)Update all the data of a product\n" + "2)Update only one data.\n" + "3)Exit\n" + "Enter your answer:\t");
        reply = scanner.nextInt();
        return reply;
    }//

    private static int validateUpdate(int reply) {
        while (reply < 1 || reply > 3) {
            System.out.print("Error you can only choose from 1 to 3\n Re-enter your answer:\t");
            reply = scanner.nextInt();
        }
        return reply;
    }//

    private static Boolean printAllProducts(MongoCollection<Document> productCollection) {
        Boolean exit;
        System.out.println("________________________Registered products ________________________________________________");
        productCollection.find().forEach(doc -> System.out.println(doc.toJson()));
        exit = true;
        System.out.println("=======================================================================");
        return exit;
    }//

    private static int subMenu() {
        int option;
        System.out.println("============================================================================");
        System.out.print("1)Display only one product.\n" + "2)View all registered products.\n" + "Enter your answer:\t");
        option = scanner.nextInt();
        return option;
    }//

    private static Boolean oneProduct(MongoCollection<Document> productCollection, MongoDatabase database) throws NumberFormatException {
        int answer;
        Boolean exit = false;
        answer = options();
        answer = validateAnswer(answer);
        if (answer == 1) {
            SearchByName(productCollection);
        } else if (answer == 2) {

            SearchByUnitPrice(database);

        } else {
            exit = true;
            return exit;

        }
        return exit;
    }//

    private static void SearchByUnitPrice(MongoDatabase database) throws NumberFormatException {
        System.out.print("Enter the unit price to be used as a basis:\t");
        double unitPrice = Double.parseDouble(scanner.next());
        Bson filter = Filters.and(Filters.gt("unit price", unitPrice));
        MongoCollection collection = database.getCollection("Product");

        MongoCursor<Document> cursor = collection.find(filter).iterator();

        System.out.println("---> " + collection.find(filter).iterator());
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }//

    private static void SearchByName(MongoCollection<Document> inventoryCollection) {
        String name;
        System.out.print("Enter the name :\t");
        name = scanner.next();
        System.out.println(name);
        System.out.println("=================");
        Bson filter = Filters.eq("name of Product", name);
        try {
            Document doc = inventoryCollection.find(Filters.and(filter)).first();
            System.out.println("product->" + doc.toJson());

        } catch (Exception e) {
            System.out.println("Data not found");
        }
    }//

    private static int options() {
        int answer;
        System.out.println("====================================================================");
        System.out.print("1)Search by name\n" + "2)Search by unit price\n" + "3)Exit\n" + "Enter your answer:\t");
        answer = scanner.nextInt();
        return answer;
    }//

    private static int validateAnswer(int answer) {
        while (answer < 1 && answer > 3) {
            System.out.println("Error try again");
            System.out.print("1)Search by name\n" + "2)Search by unit price\n" + "3)Exit\n" + "Enter your answer:\t");
            answer = scanner.nextInt();

        }
        return answer;
    }//

    public static int registerMoreProducts(Scanner console) {
        int followAction;
        System.out.println("=======================================================");
        System.out.println("Would you like to enter another product? \n Enter the number: \n(1)Yes \n(2)NO \nEnter the number:");
        followAction = console.nextInt();
        System.out.println("=======================================================");
        return followAction;
    }//

    public static void submenuInventoryManager() {
        System.out.println("------------------Welcome to Inventory-----------------");
        System.out.println("  1.Show products and stock");
        System.out.println("  2.Edit products.");

        System.out.println("  3.Exit");
        System.out.print("  Type an option:\t");
    }//

    public static void submenuInventoryEmployee() {
        System.out.println("------------------Welcome to Inventory-----------------");
        System.out.println("  1.Show products and stock");

        System.out.println("  2.Exit");
        System.out.print("  Type an option:\t");
    }//

    private static Employee registerEmployee(Employee employee) throws NumberFormatException {
        String name;
        String userName;
        String password;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the new employee:\t");
        name = scanner.next();
        System.out.print("Enter the new user name:\t");
        userName = scanner.next();
        System.out.print("Enter the password:\t");
        password = scanner.next();

        employee.setName(name);
        employee.setUserName(userName);
        employee.setPassword(password);

        return employee;
    }//

    public static void employeeSystem() {

        String uri = "mongodb+srv://alextrejo:1402oop@cluster0.ydafxco.mongodb.net/?retryWrites=true&w=majority";
        Employee employee = new Employee();
        int answer = 0;

        System.out.println("___________________________________________________________________________________________");
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("T09-PACSTORE");

            try {

                System.out.println("The connection to the EcoMarketS database was successful.");
                System.out.println("_________________________________________________________________________________________");
                MongoCollection<Document> employeeCollection = database.getCollection("Employee");

                System.out.println("1)Register new employee" + "2)Work report");

                if (answer == 1) {
                    employee = registerEmployee(employee);

                    Bson filter = Filters.eq("user_name", employee.getUserName());

                    if (employeeCollection.find(filter).first() == null) {
                        Document employeeNew = new Document("_id", new ObjectId())
                                .append("name", employee.getName())
                                .append("user_name", employee.getUserName())
                                .append("password", employee.getPassword());

                        employeeCollection.insertOne(employeeNew);

                    } else if (employeeCollection.find(filter).first() != null) {

                        System.out.println("This user name is already registered");

                    }

                }else if(answer==2){
                    
                
                }

            } catch (MongoException me) {
                System.out.println("An error occurred while attempting to connect: " + me);
            }

        }

    }//

    public static void saveProduct() {

        String uri = "mongodb+srv://alextrejo:1402oop@cluster0.ydafxco.mongodb.net/?retryWrites=true&w=majority";
        Product enteredProduct = new Product();

        System.out.println("___________________________________________________________________________________________");
        try ( MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("T09-PACSTORE");

            try {

                System.out.println("The connection to the EcoMarketS database was successful.");
                System.out.println("_________________________________________________________________________________________");
                MongoCollection<Document> productCollection = database.getCollection("Product");
                MongoCollection<Document> inventoryCollection = database.getCollection("Inventory");

                Product enteredProducts;

                enteredProducts = registerProduct(enteredProduct);

                Bson filter = Filters.eq("name of Product", enteredProduct.getName());

                if (productCollection.find(filter).first() == null) {
                    Document product = new Document("_id", new ObjectId())
                            .append("name of Product", enteredProduct.getName())
                            .append("amount", enteredProduct.getAmount())
                            .append("unit price", enteredProduct.getUnitPrice());

                    productCollection.insertOne(product);
                    Document inventory = registerInventory(enteredProduct);
                    inventoryCollection.insertOne(inventory);
                    System.out.println("New product has agragated: " + enteredProducts.getName());

                } else if (productCollection.find(filter).first() != null) {

                    System.out.println("This product is already registered");

                }

            } catch (MongoException me) {
                System.out.println("An error occurred while attempting to connect: " + me);
            }

        }

    }//

    private static Document registerInventory(Product enteredProduct) throws NumberFormatException {

        Document inventory = new Document("_id", new ObjectId())
                .append("name of Product", enteredProduct.getName())
                .append("amount", enteredProduct.getAmount());
        return inventory;

    }//

    private static Product registerProduct(Product enteredProduct) throws NumberFormatException {
        String name;
        double unitPrice;
        int amount;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the Product to register:\t");
        name = scanner.nextLine();
        System.out.print("Enter the unit price:\t");
        unitPrice = Double.parseDouble(scanner.next());

        System.out.print("Enter the amount:\t");
        amount = scanner.nextInt();

        enteredProduct.setName(name);
        enteredProduct.setUnitPrice(unitPrice);
        enteredProduct.setAmount(amount);

        return enteredProduct;
    }//

    /*public static int checkStock(int productSell, int existingAmount, Scanner console) {
        while (productSell > existingAmount) {
            System.out.println("The quantity to be sold entered exceeds the existing quantity in stock¡¡");
            System.out.print("Re-enter the quantity to be sold:\t");
            productSell = console.nextInt();
        }
        return productSell;
    }*/

 /*public static void productListingForSale(int registrationOfIncomingProducts, ArrayList<Product> register) {
        System.out.println("--------------Sales registration system----------------");
        System.out.println("=======================================================");
        System.out.println("---------------List of products in stock:--------------");
        System.out.println("Name\t\t\t\t  UnitPrice\t\t\t");
        for (int i = 0; i < registrationOfIncomingProducts; i++) {

            System.out.printf("[%d].%s \t\t\t   %.2f\t\t\t\t   \n", (i + 1), register.get(i).getName(), register.get(i).getUnitPrice());

        }
    }*/

 /*public static int compareQuantityInStock(int search, ArrayList<Inventory> stock, Scanner console) {
        while (search <= 0 || search > stock.size()) {
            System.out.println("Not registered");
            System.out.println("Enter again:");
            search = console.nextInt();
        }
        return search;
    }*/

 /*public static void printModified(ArrayList<Inventory> stock, int search) {
        System.out.println("-----------Modified quantity-----------");
        System.out.println("Name product:\t\t" + stock.get(search).getName());
        System.out.println("quantity in inventory:\t " + stock.get(search).getAmount());
        System.out.println("-----------Modified quantity-----------");
    }*/

 /*public static void printAllListOfProduct(ArrayList<Inventory> stock, int position, ArrayList<Product> register) {
        System.out.println("=======================================================");
        System.out.println("----------------------Inventory------------------------");
        System.out.println("\tName\t\t\tUnitPrice\t\t\tAmount");

        for (int i = 0; i < stock.size(); i++) {

            System.out.printf("[%d].%s \t\t\t%.2f\t\t\t\t %d\n", (i + 1), stock.get(i).getName(), register.get(i).getUnitPrice(), stock.get(i).getAmount());
            position++;

        }
    }*/

 /*public static void printProductIncreased(ArrayList<Inventory> stock, int search) {
        System.out.println("Name product:\t\t\t" + stock.get(search).getName());
        System.out.println("quantity in inventory:\t\t " + stock.get(search).getAmount());
        System.out.println("Enter the amount to be increased:\t");
    }*/

 /*public static int checkQuantityToBeEliminated(int eliminateQuantity, int existingAmount, Scanner console) {
        while (eliminateQuantity > existingAmount) {
            System.out.println("The quantity to be removed entered exceeds the existing quantity in stock¡¡");
            System.out.print("Re-enter the quantity to be deleted:\t");
            eliminateQuantity = console.nextInt();

        }
        return eliminateQuantity;
    }*/

 /*public static void printSelectedProduct(ArrayList<Inventory> stock, int search) {
        System.out.println("Name product:\t\t\t" + stock.get(search).getName());
        System.out.println("quantity in inventory:\t\t " + stock.get(search).getAmount());
        System.out.println("Enter the quantity to be removed:\t");
    }*/

 /*public static void printList(int registrationOfIncomingProducts, ArrayList<Inventory> stock) {

        System.out.println("=======================================================");
        System.out.println("----------------List of products in stock:-------------");
        System.out.println("Name\t\t\t\t Amount");
        for (int i = 0; i < registrationOfIncomingProducts; i++) {

            System.out.printf("[%d].%s \t\t\t   %d\n", (i + 1), stock.get(i).getName(), stock.get(i).getAmount());

        }
    }*/
 /*public static void enteredProduct(Product enteredProduct) throws NumberFormatException {
        String name;
        double unitPrice;
        int amount;
        System.out.print("Enter the name of the Product to register:\t");
        name = scanner.nextLine();
        System.out.print("Enter the unit price:\t");
        unitPrice = Double.parseDouble(scanner.next());
        System.out.print("Enter the amount:\t");
        amount = scanner.nextInt();
        enteredProduct.setName(name);
        enteredProduct.setUnitPrice(unitPrice);
        enteredProduct.setAmount(amount);
    }*/
 /*public static void addJsonInventary(ArrayList<Inventory> stock) {
        String save = new Gson().toJson(stock);
        try {
            try ( FileWriter write = new FileWriter("Inventary.json")) {
                write.write(save);
                write.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(EcoMarket.class.getName()).log(Level.SEVERE, null, ex);
        }

    }*/

 /*public static void addJsonRegisterProduct(ArrayList<Product> register) {
        String save = new Gson().toJson(register);

        try {
            try ( FileWriter write = new FileWriter("RegisterProduct.json")) {
                write.write(save);
                write.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(EcoMarket.class.getName()).log(Level.SEVERE, null, ex);
        }

    }*/

 /*public static void addJsonSale(ArrayList<Sale> sale) {
        String save = new Gson().toJson(sale);
        try {
            try ( FileWriter write = new FileWriter("Sale.json")) {
                write.write(save);
                write.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(EcoMarket.class.getName()).log(Level.SEVERE, null, ex);
        }

    }*/

 /* public static ArrayList<Inventory> readJSONInventory(ArrayList<Inventory> stocks) throws JsonSyntaxException {
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
            Logger.getLogger(EcoMarket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EcoMarket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stocks;
    }*/

 /*public static ArrayList<Product> readJSONProduct(ArrayList<Product> register) throws JsonSyntaxException {
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
            Logger.getLogger(EcoMarket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EcoMarket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return register;
    }*/
}
