package io_operations;
import java.io.*;
public class LaunchIO3 {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\vgopi\\OneDrive\\Desktop\\InputOutput\\java.txt";
        FileWriter writer = null;

        try {
            File file1 = new File(filePath);
            writer = new FileWriter(file1,true);
            writer.write("java");
            writer.write("\n");
            writer.write(65);//ascii value 65 = a
            writer.write("\n");
            // write an array of characters
            char[] ch = {'a','f','j'};
            writer.write(ch);
            writer.write("\n");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            writer.close();
        }
    }
}
