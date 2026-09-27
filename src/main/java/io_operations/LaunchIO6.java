package io_operations;
import java.io.*;

public class LaunchIO6 {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\vgopi\\OneDrive\\Desktop\\InputOutput\\java.txt";
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter=null;
        // Creating a file object that represents the physical file
        File file1=new File(filePath);
        // Creating a FileWriter - the basic stream to write to file
        try {
            fileWriter=new FileWriter(file1,true);
            // Attaching bufferedWriter to make writing more efficient
            bufferedWriter=new BufferedWriter(fileWriter);
            //writing a string
            bufferedWriter.write("gopi");
            // adding a new line
            bufferedWriter.newLine();
            // writing character with ASCII value 66(which is 'B'
            bufferedWriter.write(66);
            bufferedWriter.newLine();
            // writing an array of characters
            char[] ch={'k','i','n','g'};
            bufferedWriter.write(ch);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            bufferedWriter.close();
        }

    }
}
