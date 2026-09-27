package io_operations;

import java.io.FileWriter;
import java.io.*;

public class LaunchIO8 {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\vgopi\\OneDrive\\Desktop\\InputOutput\\java.txt";
        // Declare FileWriter and PrintWriter objects try
        FileWriter fileWriter=null;
        PrintWriter printWriter=null;
        // Create a file object representing the physical file
        try {
            File file1 = new File(filePath);
            fileWriter=new FileWriter(file1);
            // Create a FileWriter to write characters to the file
            //PrintWriter adds the ability to write various data types as they are
            printWriter = new PrintWriter(fileWriter);
            //Using write() method still converts numbers to their character eqivalents
            //This will write 'A' ASCII value is 65
            printWriter.write(65);
            printWriter.write("\n");
            //Using println() methods to write df data types as they are
            printWriter.println(65);
            printWriter.println("\n");
            printWriter.println("gopi");
            printWriter.println("M");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            printWriter.close();
        }

    }
}
