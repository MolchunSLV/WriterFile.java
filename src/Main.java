import model.ReaderFile;
import model.Tool;
import model.WriterFile;

public class Main {
    public static void main(String[] args)  {

        ReaderFile rf=new ReaderFile();

        Tool tools= new Tool();
        tools.CreateLines(rf.getLines());
        tools.FindId(tools.getTool().get(tools.getTool().size()-1));

        tools.AddLine("Пластина","CNMG 120408-QM 1105","Sandvik Coromant");

        tools.Update("CNMG 120408-QM 1105","CNMG 120408-QM 1115");

        tools.AddLine("Пластина","CNMG 120408-QM 1105","Sandvik Coromant");

        tools.DeleteT("CNMG 120408-QM 1105");

        WriterFile wf=new WriterFile();
        wf.WriteFile(tools.getTool());

    }
}