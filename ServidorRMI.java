import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            ConversorRemotoImpl conversor = new ConversorRemotoImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ConversorRemoto", conversor);
            System.out.println("Servidor RMI iniciado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
