package io_operations;

import java.io.File;
import java.io.*;

public class LaunchIO4 {

    public static void main(String[] args) throws IOException {
        // Path to the file we want to read
        String filePath = "C:\\Users\\vgopi\\OneDrive\\Desktop\\InputOutput\\java.txt";
        FileReader fileReader = null;
        try {
            // create a file reader to read the file
            File file1 = new File(filePath);
            // create a FileReader to read the file
            fileReader = new FileReader(file1);
            // read the first character
            int i = fileReader.read();
            //loop until we reach the end of the file
            while(i != -1){
                System.out.print(i+"=>");
                System.out.println((char)i);
                //read the next character
                i = fileReader.read();
            }
        } catch (Exception e) {
            System.out.println("Some problem: "+e.getMessage());
        } finally {
            fileReader.close();
        }
    }

}
