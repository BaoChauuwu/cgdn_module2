package casestudy.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static void writeToFile(String pathName, List<String> stringList, boolean append ) {
        File file = new File(pathName);
        try(FileWriter fileWriter = new FileWriter(file,append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ){
            for(String s : stringList){
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }

    }
    public static List<String> readFromFile(String pathName) {
        List<String> stringList = new ArrayList<>();
        File file = new File(pathName);
        try(FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);)
        {
            String line = null;
            while((line=bufferedReader.readLine())!=null){
                stringList.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return  stringList;
    }
}
