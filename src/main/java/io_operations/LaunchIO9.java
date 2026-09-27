package io_operations;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class LaunchIO9 {
    public static void main(String[] args) {
        StudentIO stu = new StudentIO(1, "rahul", 19);
        stu.disp();
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\vgopi\\OneDrive\\Desktop\\InputOutput\\serial.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("sdddddd");
            oos.writeObject(stu);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
