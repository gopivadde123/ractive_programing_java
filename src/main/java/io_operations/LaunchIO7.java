package io_operations;
import java.io.*;
public class LaunchIO7 {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\vgopi\\OneDrive\\Desktop\\InputOutput\\java.txt";
        // Declares FileReader reference
        FileReader fileReader = null;
        // Declares BufferedReader reference
        BufferedReader bufferedReader = null;
        File file1=new File(filePath);


        String str= null;
        try {
            fileReader = new FileReader(file1);
            // wrap FileReader to read the file character by character
            bufferedReader = new BufferedReader(fileReader);
            // Read the first line from the file
            str = bufferedReader.readLine();
            // Continue reading until we reach end of file (null)
            while(str != null){
                System.out.println(str);// Print the current line
                str= bufferedReader.readLine();// read the next line
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            bufferedReader.close();
        }

    }
}
