package ec.edu.espe.ecomarket.model;

/**
 *
 * @author Alex Trejo, PACSTORE, DCCO-ESPE
 */
public class Employee {

    private String name;
    private String userName;
    private String password;

    public Employee() {
        name = "";
        userName = "";
        password = "";
    }

    public Employee(String name, String userName, String password) {
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}