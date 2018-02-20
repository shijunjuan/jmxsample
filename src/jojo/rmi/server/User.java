package jojo.rmi.server;

import java.io.Serializable;

/**
 * Created by junjshi on 2/20/18.
 */
public class User implements Serializable{
    private static  final long serialVersionUID = 24L;
    String name;
    int id;

    public User(String name,int id){
        this.id = id;
        this.name = name;
    }
}
