package kaur.siimar.processor;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import kaur.siimar.client.ClientMain;

public class NormalFileProcessingService { // here actual file processing
    // 1. read a file

    public String readFile(String filePath) {
        String data = "";

        Scanner inputScanner = new Scanner(System.in);

        try {
            FileReader fReader = new FileReader(filePath); // to read file, requires file path
            StringBuffer strFile = new StringBuffer();
            int i;
            int charcount = 0;
            /*System.out.println("Here is the File content: ");
            while ((i = fReader.read()) != -1) {
                charcount += 1;
                //System.out.println((char)i);
                strFile.append((char)i);
            }*/

            // lines 25-26 are a compact implementation of lines 19-22 above
            Path path = Paths.get(filePath);
            data = Files.readString(path);
            System.out.println("Here is the Character Count: "+data.length());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
