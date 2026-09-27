package io_operations;
import java.io.*;

public class LaunchIO2 {
    public static void main(String[] args) {

        try {
//            This is for file creation
//            File file1=new File("C:\\Users\\vgopi\\OneDrive\\Desktop\\InputOutput\\java.txt");
//            System.out.println(file1.exists());
//            System.out.println(file1.createNewFile());
//            System.out.println(file1.exists());
//            This is for directory
            File dir = new File("C:\\Users\\vgopi\\OneDrive\\Desktop\\InputOutput\\Directory");
            System.out.println("Directory exsists? "+dir.exists());
            // Create the directory if it doesn't exist
            if(!dir.exists()){
                System.out.println("Directory created? "+dir.mkdir());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
