package kaur.siimar.client;
import kaur.siimar.processor.NormalFileProcessingService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;

public class ClientMain {
    public static void main(String[] args) {
        System.out.println("Welcome to the File Compressor!");
        // we want the user to pass us 4 details: file path (to read from), output path (to save the file after compressing), algorithm type,
        // compressor type (multi or single threading)
        Scanner inputScanner = new Scanner(System.in);

        InputParser.inputParser(args); //calling function from other class--> specifically to take input from CLI because validation is different for different methods of input


//
//        import java.util.Scanner;
//import java.util.Random;
//
//        class Main {
//            public static void main(String[] args){
//
////f1 = Hello
////f2 = abrakadabra
////f3 = thealchemist
//
//                FileDetails f1obj = new FileDetails();
////as FileDetails() is a defalut contstructor, all the args of the object will  be blank
//                f1obj.path = "hello.txt";
//                f1obj.size = 100;
//                f1obj.content = "Hellow this is an hello file";
//
//                FileDetails f2obj = new FileDetails();
////as FileDetails() is a defalut contstructor, all the args of the object will  be blank
//                f2obj.path = "abarakadar.txt";
//                f2obj.size = 100;
//                f2obj.content = "Hellow this is an abarakadar file";
//
//                FileDetails f3obj = new FileDetails();
////as FileDetails() is a defalut contstructor, all the args of the object will  be blank
//                f1obj.path = "hello.txt";
//                f1obj.size = 100;
//                f1obj.content = "Hellow this is an hello file";
//
//
////         to avoid this rework of setting up the atrribute value again and againe for each object we cn use a contrsuctor(cutosm)
//
//                FileDetails halfbloodprint = new FileDetails("HPpart6.txt",100, "I am upto no good");
//
//            }
//
//        }
//
//        public class FileDetails {
//
//            String path;
//            int size;
//            String content;
//            //    we are creating a new custom constructor :  it name would be same as class name/ it wont return anything
//            public FileDetails(){} // automatic
//
//
//            public FileDetails(String path,int size, String content){
//                this.path = path;
////        this => is self refence to the object being created
//                this.size =size;
//                this.content = content;
//            }
//
//
//        }

        // /u5/s32kaur/Documents/lorem.txt
    }
}
