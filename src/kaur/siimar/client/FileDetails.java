package kaur.siimar.client;

public class FileDetails {

    //once we have input, we save all these into FileDetails class.
    //attributes we should have: name of file, the string file path, [the 4 parameters from google doc]

//    private String filePath; // for file path
//    private String algoName; // for the algorithm type the user wishes to choose
//    private String threadType; // for the thread type the user would choose
//    private File fileDet; // for all file details

    String path;
    int size;
    String content;
    // later make it private

    public FileDetails(String path, int size, String content) {
        this.path = path;
        this.size = size;
        this.content = content;
    }
}
