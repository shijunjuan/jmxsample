package jojo.rmi.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by junjshi on 2/20/18.
 */
public class UserHandlerServer {

    public static void main(String[] args) throws MalformedURLException {
        UserHandler userHandler = null;
        try {
            userHandler = new UserHandlerImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            Naming.rebind("user",userHandler);
            System.out.println();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
