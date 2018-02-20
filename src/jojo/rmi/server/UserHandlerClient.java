package jojo.rmi.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by junjshi on 2/20/18.
 */
public class UserHandlerClient {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        UserHandler handler = (UserHandler) Naming.lookup("rmi://localhost:1099/user");
        int  count = handler.getUserCount();
        String name = handler.getUserName(1);
        System.out.println("name: " + name);
        System.out.println("count: " + count);
        System.out.println("user: " + handler.getUserByName("lmy86263"));
    }
}
