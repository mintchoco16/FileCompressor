package kaur.siimar.client;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;

public class ClientMain {
    public static void main(String[] args) {
        System.out.println("Welcome to the File Compressor!");
        // we want the user to pass us 4 details: file path (to read from), output path (to save the file after compressing), algorithm type,
        // compressor type (multi or single threading)

        InputParser.inputParser(args); //calling function from other class--> specifically to take input from CLI because validation is different for different methods of input

        System.out.println("Please provide the Path of the File / Folder you wish to compress: ");

        Scanner inputScanner = new Scanner(System.in);
        String filePath = inputScanner.nextLine();
        System.out.println("Here is the entered path: "+filePath);

        try {
            FileReader fReader = new FileReader(filePath); // to read file, requires file path
            int i;
            int charcount = 0;
            System.out.println("Here is the File content: ");
            while ((i = fReader.read()) != -1) {
                charcount += 1;
                System.out.print((char)i);
            }
            System.out.println("Here is the Character Count: "+charcount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

        }
    }
}
