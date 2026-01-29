import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class RMIClient {

    public static void main(String[] args) {

        try {
            Registry registry =
                LocateRegistry.getRegistry("98.70.25.35", 1099);

            ComputeService service =
                (ComputeService) registry.lookup("ComputeService");

            int[][] A = {{1,2},{3,4}};
            int[][] B = {{5,6},{7,8}};

            int[][] result = service.multiplyMatrix(A, B);

            System.out.println("Matrix Result:");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++)
                    System.out.print(result[i][j] + " ");
                System.out.println();
            }

            List<Integer> primes = service.getPrimes(30);
            System.out.println("Prime Numbers: " + primes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
