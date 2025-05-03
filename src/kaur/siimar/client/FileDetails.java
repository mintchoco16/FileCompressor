package kaur.siimar.client;

public class FileDetails {

    //once we have input, we save all these into FileDetails class.

    private String path;
    private long size;
    private String content;

    public FileDetails(String path, long size, String content) {
        this.path = path;
        this.size = size;
        this.content = content;
    }

    public long getSize() {
        return this.size; // cannot access it beyond this class because private attribute
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
