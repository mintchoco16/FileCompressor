package kaur.siimar.client;

import kaur.siimar.processor.NormalFileProcessingService;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputParser {

    // take from cli itself in main class
    // once we have input, we save all these into FileDetails class.
    // to put all the details into File object- so to validate and parse the input data this class is used


    public static List<FileDetails> inputParser() {
        System.out.println("Your input is being loaded, kindly wait a moment... :)");

        Scanner inputScanner = new Scanner(System.in);
        NormalFileProcessingService fileProcObj = new NormalFileProcessingService();
        
        System.out.println("Please press '1' for Path of the File or '2' for Path of the Folder you wish to compress: ");
        List<FileDetails> listOfFileDetails = new ArrayList<>(); // use ArrayList cus don't want to specify size bcs unsure of number of elts we'll receive

        try {
            int optionSelect = inputScanner.nextInt();
            inputScanner.nextLine();
            System.out.println("Enter the path: ");
            String fPath = inputScanner.nextLine();

            if (optionSelect == 1) {
                FileDetails processedFile = fileProcObj.readFile(fPath); // don't use getPath() here because dealing directly with string input of file path
                int fileOrigSize = processedFile.getSize() * 8;
                System.out.println("Here is the entered path: " + processedFile.getPath() + ", size of file: " + fileOrigSize);
                listOfFileDetails.add(processedFile);
            } else if (optionSelect == 2) {
                File folder = new File(fPath);
                File[] listOfFiles = folder.listFiles();

                for (File f : listOfFiles) { // this for loop is in range format, like Python- eg: for f in ___

                    System.out.println("Currently Reading File with Path: " + f.getPath());
                    FileDetails processedFile = fileProcObj.readFile(f.getPath()); // using this here because File[] would make all folder contents as objects
                    // making the object here so that we can also store the file name and path instead of just having the content because that will help in knowing what to return to which file and where the current content came from instead of having ambiguity when we just get the content returned and don't have an object storing/giving that information.
                    System.out.println("Here is the entered path: " + processedFile.getPath() + ", size of file: " + processedFile.getSize());
                    listOfFileDetails.add(processedFile);
                }

            } else {
                System.out.println("Invalid Input Number, please enter either '1' or '2'.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
        }

        return listOfFileDetails;
    }


}
