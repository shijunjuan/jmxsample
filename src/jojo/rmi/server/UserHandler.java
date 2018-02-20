package jojo.rmi.server;


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by junjshi on 2/20/18.
 */
public interface UserHandler extends Remote {

    String getUserName(int id) throws RemoteException;
    int getUserCount() throws RemoteException;
    User getUserByName(String name) throws RemoteException;

}
