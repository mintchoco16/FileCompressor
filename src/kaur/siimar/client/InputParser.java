package kaur.siimar.client;

import kaur.siimar.processor.NormalFileProcessingService;

import java.io.File;
import java.util.Scanner;

public class InputParser {

    // take from cli itself in main class
    // once we have input, we save all these into FileDetails class.
    // to put all the details into File object- so to validate and parse the input data this class is used


    public static FileDetails inputParser(String args[]) {
        System.out.println("Your input is being loaded, kindly wait a moment... :)");

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Please press '1' for Path of the File or '2' for Path of the Folder you wish to compress: ");
        int optionSelect = inputScanner.nextInt();
        System.out.println("Enter the path: ");
        String fPath = inputScanner.nextLine();
        System.out.println("Here is the entered path: "+fPath);

        if (optionSelect == 1) {
            NormalFileProcessingService fileProcObj = new NormalFileProcessingService();
            fileProcObj.readFile(fPath); // don't use getPath() here because dealing directly with string input of file path
        } else if (optionSelect == 2) {
            File Folder = new File(fPath);
            File[] listOfFiles = Folder.listFiles();

            for (File f : listOfFiles) { // this for loop is in range format, like Python- eg: for f in ___
                NormalFileProcessingService fileProcObj = new NormalFileProcessingService();
                System.out.println("Currently Reading File with Path: " +f.getPath());
                fileProcObj.readFile(f.getPath()); // using this here because File[] would make all folder contents as objects

            }

        } else {
            System.out.println("Invalid Input, please enter either '1' or '2'.");
        }

    }


}
