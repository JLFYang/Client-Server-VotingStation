// A simple RMI interface file - M. Liu
import java.rmi.*;

public interface Interface extends Remote {

    String welcome() throws java.rmi.RemoteException;

    void vote(String choice) throws java.rmi.RemoteException;

    int checkStatus(String check) throws java.rmi.RemoteException;
}    
