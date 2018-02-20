package jojo.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by junjshi on 2/20/18.
 */
public class HelloImpl extends UnicastRemoteObject implements  Hello {

    protected HelloImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String name) throws RemoteException  {
        System.out.println(name);
        return "Hello " + name;
    }
}
