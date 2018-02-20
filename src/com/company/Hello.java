package com.company;

/**
 * Created by junjshi on 2/20/18.
 */
public class Hello implements HelloMBean{

    private String name;

    private String age;

    @Override
    public String getName() {
        System.out.println("get name "+name);
        return name;
    }

    @Override
    public void setName(String name) {
        System.out.println("set name " +name);
        this.name = name;
    }

    @Override
    public String getAge() {
        System.out.println("get age 123");
        return age;
    }

    @Override
    public void setAge(String age) {
        System.out.println("set age 123");
        this.age = age;
    }

    @Override
    public void helloWorld() {
        String name = (this.getName()==null)?"":this.getName();

        System.out.println("hello world:"+ name);
    }

    @Override
    public void helloWorld(String str) {
        System.out.println("helloWorld:" + str);
    }

    @Override
    public void getTelephone() {
        System.out.println("get Telephone");
    }
}
