package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class WriterFile {
    File file=new File("tool.txt");
    PrintWriter pw;

    public void WriteFile (List<String> lines){

        try {
            pw = new PrintWriter(file);
            for (String line:lines){
                pw.println(line);
            }

            pw.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
