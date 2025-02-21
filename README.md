# File Compressor

File Compressor is a Java application that allows users to input file or folder paths through the command line, processes them, and retrieves details such as the size and content of the files to be compressed. This project supports both single and multi-threaded compression methods.

## Installation

Clone or download the repository and compile the Java files.

### Steps:
1. Ensure you have Java installed on your system.
2. Compile the Java files using the command:

```bash
javac kaur/siimar/client/*.java kaur/siimar/processor/*.java
```

3. Run the application:

```bash
java kaur.siimar.client.ClientMain
```

## Usage

```java
import kaur.siimar.client.InputParser;

// Running the InputParser to get file or folder details
InputParser.inputParser();
```

1. The program prompts the user to input either:
    - A file path, or
    - A folder path containing files to be processed.
   
2. After receiving the input, it processes the data and outputs:
    - The file path and size for a single file.
    - The path and size of each file within a folder.

## Example:

```bash
Welcome to the File Compressor!
Please press '1' for Path of the File or '2' for Path of the Folder you wish to compress: 
1
Enter the path: 
/u5/s32kaur/Documents/testfolder/lorem.txt
Here is the entered path: /u5/s32kaur/Documents/testfolder/lorem.txt, size of file: 1024
```

For folder input, it will list all files and their sizes within the folder.

## Code Breakdown

### 1. **InputParser.java**
The `InputParser` class handles the command-line interaction to collect file or folder paths. It validates the input, processes the file details, and prints the output.

### 2. **NormalFileProcessingService.java**
The `NormalFileProcessingService` class is responsible for reading the content of a file and creating a `FileDetails` object containing the file's path, size, and content.

### 3. **FileDetails.java**
The `FileDetails` class holds the path, size, and content of a file.

### 4. **ClientMain.java**
The main class to run the application, which calls the `InputParser` class to initiate the input and processing of files.
