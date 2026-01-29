import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ComputeServiceImpl extends UnicastRemoteObject
        implements ComputeService {

    protected ComputeServiceImpl() throws RemoteException {
        super();
    }

    public int[][] multiplyMatrix(int[][] A, int[][] B)
            throws RemoteException {

        int[][] result = new int[2][2];

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 2; k++)
                    result[i][j] += A[i][k] * B[k][j];

        return result;
    }

    public List<Integer> getPrimes(int n) throws RemoteException {

        List<Integer> primes = new ArrayList<>();

        for (int num = 2; num <= n; num++) {
            boolean prime = true;

            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime)
                primes.add(num);
        }
        return primes;
    }
}
