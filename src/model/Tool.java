package model;

import java.util.ArrayList;
import java.util.List;

public class Tool {
    List<String> tool=new ArrayList<>();

    public List<String> getTool() {
        return tool;
    }

    public void setTool(List<String> tool) {
        this.tool = tool;
    }

    int id=0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void CreateLines(List<String> lines){
        if (lines.isEmpty()){
            lines.add("Id!   !Name!   !Attribute!   !Company");
        } else if(!lines.get(0).contains("Id")){
            lines.clear();
            lines.add("Id!   !Name!   !Attribute!   !Company");
        }
        setTool(lines);
    }

    public int FindId(String str){
        try{
            if (str.contentEquals("id!")){
                id=0;
            } else {
                String[] words=str.split("!   !");
                id=Integer.parseInt(words[0]);
            }
            return 0;
        } catch (Exception ex){
            return 0;
        }

    }

    public void AddLine(String str1, String str2, String str3) {
        String val1=StrWOS(str2);
        String val2="";
        boolean rep=false;
        for (String line:tool){
            String[] wordIL=line.split("!   !");
            val2=StrWOS(wordIL[2]);
            rep=val2.contentEquals(val1);
            if (rep){
                break;
            }
        }
        if (rep){
            System.out.println("Строка уже есть");
        } else {
            String line= String.join("!   !", String.valueOf(id+1), str1, str2, str3);
            id++;
            tool.add(line);
        }
    }

    public void Update(String str1, String str2) {
        String val1=StrWOS(str1);
        for (int j=0;j<tool.size();j++) {
            String[] wordIL = tool.get(j).split("!   !");
            boolean check=false;
            for (int i=0;i<wordIL.length;i++){
                String val2=StrWOS(wordIL[i]);
                if (val2.contentEquals(val1)){
                    check=true;
                    wordIL[i]=str2;
                }
            }

            String str="";
            for (int k=0;k<wordIL.length;k++){
                if (k==0){
                    str=wordIL[k];
                } else {
                    str=str+"!   !"+wordIL[k];
                }
            }

            if (check) {
                tool.set(j, str);
            }
        }
    }

    public void DeleteT(String str1){
        String val1=StrWOS(str1);
        int val=0;
        for (int j=0; j<tool.size();j++){
            String[] wordIL = tool.get(j).split("!   !");
            for (int i=0;i<wordIL.length;i++){
                String val2=StrWOS(wordIL[i]);
                if (val2.contentEquals(val1)){
                    val=j;
                }
            }
        }
        if (val==0){
            System.out.println("Нет такой строки");
        } else {
            tool.remove(val-1);
        }
    }

    public void Print(){
        for (String line:tool){
            String[] words=line.split("!   !");
            if (words[0].contains("Id")){
                System.out.println("Наименование"+"\tШифр"+"\tФирма");
            }else {
                System.out.println(words[1] + " " + words[2] + " " + "(ф." + words[3] + ")");
            }
        }
    }
    private String StrWOS (String str){
        String out="";
        String[] words=str.split("\\s|\\.|\\-");
        for (int i=0;i<words.length;i++){
            if(i==0){
                out=words[i];
            } else{
                out=out+words[i];
            }
        }
        return out;
    }
}

