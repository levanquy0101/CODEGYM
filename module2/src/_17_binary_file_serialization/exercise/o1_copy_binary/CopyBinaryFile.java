package _17_binary_file_serialization.exercise.o1_copy_binary;

import java.io.*;

public class CopyBinaryFile {
    private static final String source = "src\\_17_binary_file_serialization\\exercise\\o\\Beautiful_in_White.mp3";
    private static final String des = "src\\_17_binary_file_serialization\\exercise\\o\\Beautiful_in_White_copy.mp3";

    public static void main(String[] args) {
        try {
            System.out.println(copy());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private static long copy() throws IOException {
        InputStream inputStream = new FileInputStream(source);
        OutputStream outputStream = new FileOutputStream(des);
        byte[] bytes = new byte[1024];
        int length;

        while ((length = inputStream.read(bytes)) > 0){
            outputStream.write(bytes);
        }

        inputStream.close();
        outputStream.close();
        File file= new File(des);
        return file.length();
    }
}
