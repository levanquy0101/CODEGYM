package _16_io_text_file.practice.p1_sum_number;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SumNumberInFile {
    private static final String PATH="src\\_16_io_text_file\\practice\\p1_sum_number\\numbers.txt";

    public static void main(String[] args) {
        try{
            File file= new File(PATH);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int sum = 0;
            while ((line = br.readLine()) != null) {
                sum += Integer.parseInt(line);
            }
            br.close();
            System.out.println(sum);
        }
        catch (Exception ex){
            System.err.println("Fie not exists or content error!");
        }
    }
}
