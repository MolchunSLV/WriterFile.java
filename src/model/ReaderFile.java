package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderFile {
    File file=new File("tool.txt");
    Scanner scanner;
    List<String> lines = new ArrayList<>();

    {
        try {
            scanner = new Scanner(file);

            do {
                lines.add(scanner.nextLine());
            } while (scanner.hasNextLine());

            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getLines() {
        return lines;
    }

    public void Print(){
        for (String line:lines){
            String[] words=line.split("!   !");
            System.out.println(words[1]+" "+words[2]+" "+"(ф."+words[3]+")");

        }
    }

}
