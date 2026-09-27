package io_operations;

import java.io.*;
import java.io.FileReader;

public class LaunchIO5 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\vgopi\\OneDrive\\Desktop\\InputOutput\\java.txt";
        FileReader fileReader = null;
        File file1 = new File(filePath);
        // create filereader to read the file
        try {
            fileReader = new FileReader(file1);
            // create a character array with length equal to the files size
            // file1.length() returns the file size in bytes
            char[] ch=new char[(int)file1.length()];
            // read the entire file into the character array
            // this fills the entire array in one operation
            fileReader.read(ch);
            // loop through and print each character in the array
            for(char c : ch){
                System.out.print(c);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
}
