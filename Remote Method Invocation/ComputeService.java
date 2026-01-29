import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ComputeService extends Remote {
    int[][] multiplyMatrix(int[][] A, int[][] B) throws RemoteException;
    List<Integer> getPrimes(int n) throws RemoteException;
}
