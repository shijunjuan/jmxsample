package jojo.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by junjshi on 2/20/18.
 */
public class HelloClient {

    public static void main(String[] args) {
        try {
            Hello h = (Hello) Naming.lookup("rmi://127.0.0.1:12312/Hello");
            System.out.println(h.sayHello("zx"));
        } catch (MalformedURLException e) {
            System.out.println("url格式异常");
        } catch (RemoteException e) {
            System.out.println("创建对象异常");
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.out.println("对象未绑定");
        }
    }
}
