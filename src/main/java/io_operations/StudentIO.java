package io_operations;

import java.io.*;

public class StudentIO implements Serializable {
    private int id;
    private String name;
    private int age;

    public StudentIO(int id,String name,int age){
        this.age = age;
        this.id=id;
        this.name=name;
    }
    public void disp(){
        System.out.println("id"+id);
        System.out.println("name "+name);
        System.out.println("age "+age);
    }

}
