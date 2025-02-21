package kaur.siimar.processor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import kaur.siimar.client.FileDetails;

public class NormalFileProcessingService { // here actual file processing
    // 1. read a file

    public FileDetails readFile(String filePath) {
        String data = "";

        try {
            // lines 25-26 are a compact implementation of lines 19-22(while loop) above
            Path path = Paths.get(filePath);
            data = Files.readString(path); // takes in path but gives out the entire data
            return new FileDetails(filePath, data.length(), data); // creating object that contains value for these three
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
