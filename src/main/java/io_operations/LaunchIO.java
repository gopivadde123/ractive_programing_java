package io_operations;

class Student {
    private int id;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // Parameterized constructor to initialize student data
    public Student(int id,String name,int age){
        this.age = age;
        this.id = id;
        this.name = name;
    }
}
public class LaunchIO {
    public static void main(String[] args) {
        Student s1=new Student(1,"gopi",16);
        System.out.println(s1);

        Student s2 = new Student(2,"Rohit",19);
        System.out.println(s2);
    }
}
