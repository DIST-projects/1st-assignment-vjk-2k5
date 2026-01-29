import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {

    public static void main(String[] args) {

        try {
            ComputeService service = new ComputeServiceImpl();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ComputeService", service);

            System.out.println("RMI Server running on port 1099");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
