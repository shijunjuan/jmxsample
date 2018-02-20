package jojo.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by junjshi on 2/20/18.
 */
public class HelloServer {
    public static void main(String[] args) {
        try {
            Hello h = new HelloImpl();
            LocateRegistry.createRegistry(12312);
            Naming.bind("rmi://127.0.0.1:12312/Hello", h);
            System.out.println("HelloServer启动成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
