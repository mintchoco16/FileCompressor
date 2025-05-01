package kaur.siimar.client;
import kaur.siimar.processor.HuffmanCoder;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientMain {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to the File Compressor!");
        // we want the user to pass us 4 details: file path (to read from), output path (to save the file after compressing), algorithm type,
        // compressor type (multi or single threading)

        List<FileDetails> filesList = InputParser.inputParser(); //calling function from other class--> specifically to take input from CLI because validation is different for different methods of input
        long startTime = System.currentTimeMillis();
        if (filesList.isEmpty()) {
            System.out.println("There is nothing to compress :( ");
        } else {
            for (int i = 0; i < filesList.size(); ++i) {
                // fileCompression(filesList, i); // if loop code inside here, we can't do everything simultaneously-> extracted below now!
                // so, first we create a thread pool-> like collection of threads-> type of way which helps us manage threads & control their behaviour
                // for loop still used but before, the next iteration wouldn't start until first iteration compression wouldn't be complete
                // but now, we move file by file but as soon as we're done assigning work ot one thread, we move onto the next file and jump onto
                // the next thread and assign that to the second thread and so on
                // in thread pool, we can limit the number of threads working to save cpu power
                // once a thread is finished with its work, we can reuse that same thread itself to utilize it to solve another task!
                // we can create as many threads as we want. No limitation- but we shouldn't create unlimited number of threads- cus of system limitations
                // ~1 cpu core used per thread execution
                ExecutorService executor = Executors.newFixedThreadPool(3); // ideally, we should limit the max num of threads being created and so, fixed it to 3 here
                int finalI = i;
                Runnable task = () -> {
                    try {
                        fileCompression(filesList, finalI);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                };
                executor.submit(task);

            }
            System.out.println("Total time taken: " + (System.currentTimeMillis() - startTime) + " milliseconds");
            System.out.println("Number of Files Compressed: "+ filesList.size());
        }

        // /u5/s32kaur/Documents/testfolder/lorem.txt
        // /u5/s32kaur/Documents/testfolder/l.txt
        // /u5/s32kaur/Documents/testfolder
    }

    private static void fileCompression(List<FileDetails> filesList, int i) throws Exception {
        String currFileContent = filesList.get(i).getContent();
        int fileOrigSize = filesList.get(i).getSize() * 8;
        // create new object of HuffmanCoder
        HuffmanCoder hc = new HuffmanCoder(currFileContent);
        String encodedContent = hc.encode(currFileContent);
        int fileEncSize = encodedContent.length();
        //System.out.println(encodedContent);
        //System.out.println(fileEncSize);
        String decodedContent = hc.decode(encodedContent);
        //System.out.println(decodedContent);
        //System.out.println(fileOrigSize);

        double reductionPercent = ((fileOrigSize - fileEncSize) / (double) fileOrigSize) * 100;
        System.out.printf("Compression reduced size of the file: " + filesList.get(i).getPath() + " by: %.2f%%\n", reductionPercent);
    }
}
