
package ec.edu.espe.ecomarket.model;

/**
 *
 * @author Alex Trejo, PACSTORE, DCCO-ESPE
 */
public class IdCustomer {
    
     public static boolean validateID(String cedula) {
        if (cedula.length() != 10) {
            
            return false;
        }
        int suma = 0;
        for (int i = 0; i < 9; i++) {
            int digito = Integer.parseInt(cedula.charAt(i) + "");
            if (i % 2 == 0) {
                digito = digito * 2;
                if (digito > 9) {
                    digito -= 9;
                }
            }
            suma += digito;
        }
        int ultimoDigito = Integer.parseInt(cedula.charAt(9) + "");
        int digitoVerificador = 10 - (suma % 10);
        if (digitoVerificador == 10) {
            digitoVerificador = 0;
        }
        return ultimoDigito == digitoVerificador;
    }
    
}
