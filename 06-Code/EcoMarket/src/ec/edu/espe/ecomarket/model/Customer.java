package ec.edu.espe.ecomarket.model;

/**
 *
 * @author Alex Trejo, PACSTORE, DCCO-ESPE
 */
public class Customer {

    private String nameOfClient;
    private int numberOfTimesHeHasCome;
    private String IdCustomer;
    private String email;

    public Customer(String nameOfClient, int numberOfTimesHeHasCome, String IdCustomer, String email) {
        this.nameOfClient = nameOfClient;
        this.numberOfTimesHeHasCome = numberOfTimesHeHasCome;
        this.IdCustomer = IdCustomer;
        this.email = email;
    }
    
     public Customer() {
        nameOfClient = "";
        numberOfTimesHeHasCome = 0;
        IdCustomer = "";
        email = "";
    }

    
    
    
    
    public String getNameOfClient() {
        return nameOfClient;
    }

    public void setNameOfClient(String nameOfClient) {
        this.nameOfClient = nameOfClient;
    }

    public int getNumberOfTimesHeHasCome() {
        return numberOfTimesHeHasCome;
    }

    public void setNumberOfTimesHeHasCome(int numberOfTimesHeHasCome) {
        this.numberOfTimesHeHasCome = numberOfTimesHeHasCome;
    }

    public String getIdCustomer() {
        return IdCustomer;
    }

    public void setIdCustomer(String IdCustomer) {
        this.IdCustomer = IdCustomer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    

}
