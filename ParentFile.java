import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class ParentFile {
    public static void main(String[] args) throws FileNotFoundException {
        File f=new File("fileinput.txt");
        Scanner read=new Scanner(f);
        String[] fileNames = new String[6];
        for(int i=0;i<6;i++)
        {
            fileNames[i]=read.nextLine();
        }
        Hierarchy h=new Hierarchy();
        h.spacing(fileNames); 
    }
}
class Hierarchy{
    void spacing(String fileNames[]){
        HashMap<String, String> fileMap = new HashMap<>();
        fileMap.put("File1", null);
        for (int i = 1; i < fileNames.length; i++) {
            String currFile = fileNames[i].trim();
            int numSpaces = fileNames[i].length() - currFile.length();
            if (numSpaces == 1) {
                fileMap.put(currFile, "File1");
            } else if (numSpaces > 1) {
                String parentFile = fileNames[i-1].trim();
                fileMap.put(currFile, parentFile);
            } else {
                fileMap.put(currFile, null);
            }
        }
        System.out.printf("%-10s %-10s\n", "FileName", "ParentFile");
        System.out.println("========== ==========");
        for (String file : fileMap.keySet()) {
            System.out.printf("%-10s %-10s\n", file, fileMap.get(file));
        }
    }
}
