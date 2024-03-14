package _16_io_text_file.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class P2_MaxValueInFile {
    private static final String PATH="src\\_16_io_text_file\\practice\\p1_sum_number\\numbers.txt";

    public static void main(String[] args) {
        try{
            File file= new File(PATH);
            BufferedReader bufferedReader= new BufferedReader(new FileReader(file));
            String line;
            ArrayList<Integer> arrayList= new ArrayList();

            while ((line= bufferedReader.readLine()) !=null){
                arrayList.add(Integer.parseInt(line));
            }
            bufferedReader.close();
            System.out.println(max(arrayList));
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static int max(ArrayList<Integer> val){
        int res=0;
        int size= val.size();
        for (int i = 0; i < size; i++) {
            if(res< val.get(i)) {
                res = val.get(i);
            }
        }

        return res;
    }
}
