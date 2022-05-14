package datastructuresproject2.part2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
      public static SeparateChainHash<String,String> sch = new SeparateChainHash(400);

      public static void readFile(){
        String [] fileNames = {"text1","text2","text3","text4","text5","text6","text7","text8","text9","text10"};
        File filePackage = new File("C:\\Users\\Basak\\OneDrive\\Documents\\NetBeansProjects\\DataStructures-Project2-Part2\\filefolder");
        File[] files = filePackage.listFiles();
        int fileNumber = 0;
        for (File file : files) { // file next 
            if (file.isFile()) {
                Scanner input = null;
                try {
                    input = new Scanner(new FileReader(file));
                    while (input.hasNext()) {
                        String line = input.next();
                       //sch.insert(line,files[fileNumber].toString());
                       sch.insert(line,fileNames[fileNumber]);
                    }
                } catch (IOException e) {
                    System.out.println("Exception :(");
                }
                input.close();
            }
            fileNumber++;
        }
    }   
}