package ec.edu.espe.ecomarket.model;


/**
 *
 * @author Alex Trejo, PACSTORE, DCCO-ESPE
 */
public class EmailCustomer {

       public static boolean validateEmail(String email) {
        // Buscar la posición del caracter @
        int arroba = email.indexOf("@");
        if (arroba == -1) {
            // No se encontró el caracter @
            return false;
        }
        // Buscar la posición del último punto
        int punto = email.lastIndexOf(".");
        if (punto == -1) {
            // No se encontró ningún punto
            return false;
        }
        if (punto < arroba) {
            // El punto aparece antes del @
            return false;
        }
        if (punto >= email.length() - 2) {
            // El punto aparece demasiado cerca del final de la cadena
            return false;
        }
        return true;
       }
}
