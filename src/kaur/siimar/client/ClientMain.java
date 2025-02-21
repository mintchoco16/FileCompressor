package kaur.siimar.client;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        System.out.println("Welcome to the File Compressor!");
        // we want the user to pass us 4 details: file path (to read from), output path (to save the file after compressing), algorithm type,
        // compressor type (multi or single threading)

        InputParser.inputParser(); //calling function from other class--> specifically to take input from CLI because validation is different for different methods of input

        // /u5/s32kaur/Documents/testfolder/lorem.txt
        // /u5/s32kaur/Documents/testfolder
    }
}
