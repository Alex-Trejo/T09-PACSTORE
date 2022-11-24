package ec.edu.espe.HuertoEcoMarket.Simulator;

import ec.edu.espe.HuertoEcoMarket.model.RegisterProduct;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author David Toapanta, Pacstore, DCCO-ESPE
 */
public class HuertoEcoMarketSimulator {

    public static void main(String[] args) {

        System.out.println("       UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE       ");
        System.out.println("                       Project");
        System.out.println("                  HUERTO ECO-MARKET\n");
        System.out.println("      Integrantes: Reishel Tipan\n"
                + "                   David Toapanta\n"
                + "                   Carlos Torres\n"
                + "                   Alex Trejo\n");

        System.out.println("             Instructor: Edison Lascano");
        System.out.println("=========================================================");
        System.out.println("        ¡WELCOME TO CHICKEN FARM SIMULATOR :)!       ");

        int option;
        String name;
        int amount;
        double unitPrice;

        String continue1;

        Scanner console = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1)- register products:");
        System.out.println("2)- Inventory:");
        System.out.println("3)- sale:");
        option = Integer.parseInt(console.nextLine());

        switch (option) {
            case 1 -> {
                do {
                    try {
                        System.out.println("Enter the name of the Product to register:");
                        name = console.nextLine();
                        System.out.println("Enter the number of boxes:");
                        amount = Integer.parseInt(console.nextLine());
                        System.out.println("Enter the unit price:");
                        unitPrice = Double.parseDouble(console.nextLine());
                        
                        RegisterProduct registerProduct = new RegisterProduct(name, amount, unitPrice);
                        
                        registerProduct.setName(name);
                        registerProduct.setAmount(amount);
                        registerProduct.setUnitPrice(unitPrice);
                        
                        printProducts(registerProduct);
                        
                        System.out.println("registerProduct = " + registerProduct);

                    } catch(NumberFormatException er) {
                        System.out.println("the type of value entered is incorrect try again");
                    }

                    System.out.println("you want to continue press yes");
                    continue1 = console.nextLine();

                } while (continue1.equals("yes"));

                break;
            }
            case 2 -> {
                break;
            }
            case 3 -> {
                break;
            }
        }
    }
    private static void printProducts(RegisterProduct registerProduct){
        System.out.println("introduced or added \t--> " + registerProduct.getName());
        System.out.println("product packagest \t--> " + registerProduct.getAmount());
        System.out.println("full value is $ \t--> " + registerProduct.getUnitPrice());
    }
}


