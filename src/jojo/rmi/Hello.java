package jojo.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by junjshi on 2/20/18.
 */
public interface Hello extends Remote {

    public String sayHello(String name) throws RemoteException;  ;
}
