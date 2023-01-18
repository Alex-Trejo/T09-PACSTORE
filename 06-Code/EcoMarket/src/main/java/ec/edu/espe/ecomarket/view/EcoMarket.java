package ec.edu.espe.ecomarket.view;

import ec.edu.espe.ecomarket.controller.FileManager;
import ec.edu.espe.ecomarket.model.Employee;
import ec.edu.espe.ecomarket.model.Inventory;
import ec.edu.espe.ecomarket.model.Manager;
import ec.edu.espe.ecomarket.model.Product;
import ec.edu.espe.ecomarket.model.Sale;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Alex Trejo, PACSTORE, DCCO-ESPE
 */
public class EcoMarket {

    public static void main(String[] args) {
        int option = 0;

        Boolean exit = false;

        

        Manager manager = new Manager();

        Employee employee = new Employee();

        

        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            FileManager.newMenu();

            try {
                System.out.println("Enter the option:");
                option = scanner.nextInt();

                switch (option) {
                    case 1 -> {

                        int state;
                        int optionManager;
                        manager = FileManager.userLogin();
                        state = FileManager.validateUserManager(manager);

                        state = FileManager.reenterManagerData(state);

                        while (state != 0) {
                            FileManager.actionsOfTheManager();

                            try {
                                System.out.print("Enter your answer:\t");
                                optionManager = scanner.nextInt();

                                switch (optionManager) {
                                    case 1 -> {
                                        int followAction = 1;
                                        while (followAction == 1) {

                                            FileManager.saveProduct();

                                            followAction = FileManager.registerMoreProducts(scanner);

                                        }
                                    }

                                    case 2 -> {

                                        int submenuOptions = 0;
                                        while (submenuOptions != 3) {
                                            FileManager.submenuInventoryManager();
                                            submenuOptions = scanner.nextInt();

                                            switch (submenuOptions) {
                                                case 1 -> {

                                                    FileManager.viewProduct();

                                                }
                                                case 2 -> {

                                                    FileManager.updateData();

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
                                        FileManager.saleProductManager(manager);

                                    }

                                    case 4 -> {

                                        FileManager.employeeSystem();

                                    }

                                    case 5 ->
                                        state = 0;
                                    default ->
                                        System.out.println("The options are from 1 to 5");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("You only have to enter numbers");
                                System.out.println("=======================================================");

                            } catch (RuntimeException e) {
                                e.printStackTrace();
                            }

                        }

                    }

                    case 2 -> {

                        int state;
                        boolean statusTwo=true;
                        
                        int optionEmployee;
                        employee = FileManager.userLoginEmployee();
                        state = FileManager.validateUserEmployee(employee);
                        
                        employee = FileManager.reenterEmployeeData(state);
                        
                        
                        System.out.println("name+asas-->"+employee.getName()); 
                        while (statusTwo!=false) {
                            FileManager.actionsOfTheEmployee();

                            try {
                                System.out.print("Enter your answer:\t");
                                optionEmployee = scanner.nextInt();

                                switch (optionEmployee) {
                                    case 1 -> {
                                        System.out.println("name__z"+employee.getName());
                                        FileManager.saleProductEmployee(employee.getName());

                                    }

                                    case 2 -> {
                                        FileManager.viewProductEmployee();

                                    }

                                    case 3 -> {
                                        state = 0;
                                    }

                                    default ->
                                        System.out.println("The options are from 1 to 2");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("You only have to enter numbers");
                                System.out.println("=======================================================");

                            } catch (RuntimeException e) {
                                e.printStackTrace();
                            }

                        }

                    }

                    case 3 ->
                        exit = true;
                    default ->
                        System.out.println("The options are from 1 to 3");
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
}
