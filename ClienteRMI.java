

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClienteRMI {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            ConversorRemoto stub = (ConversorRemoto) registry.lookup("ConversorRemoto");

            Scanner scanner = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("Seleccione la conversión:\n1. Celsius a Fahrenheit\n2. Fahrenheit a Celsius\n3. Salir");
                opcion = scanner.nextInt();
                if (opcion == 1) {
                    System.out.println("Ingrese la temperatura en Celsius:");
                    double temp = scanner.nextDouble();
                    System.out.println("Resultado: " + stub.celsiusToFahrenheit(temp) + " Fahrenheit");
                } else if (opcion == 2) {
                    System.out.println("Ingrese la temperatura en Fahrenheit:");
                    double temp = scanner.nextDouble();
                    System.out.println("Resultado: " + stub.fahrenheitToCelsius(temp) + " Celsius");
                } else if (opcion == 3) {
                    System.out.println("Saliendo...");
                } else {
                    System.out.println("Opción no válida.");
                }
            } while (opcion != 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
