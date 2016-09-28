package Task_1_File_Directory;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileDirectory extends File {


    private ArrayList<FileDirectory> dir;
    private ArrayList<File> txt;
    private ArrayList<File> other;
    private static FileDirectory root;

    FileDirectory(String path){
        super(path);
        dir = new ArrayList<>();
        txt = new ArrayList<>();
        other = new ArrayList<>();
        sortFiles();
    }

    public void setRoot(FileDirectory f){
        root = f;
    }

    private void sortFiles(){
        File[] fileList = this.listFiles();
        if (fileList != null) {
            for (File f : fileList) {
                if (f.isDirectory()) {
                    FileDirectory f1 = new FileDirectory(f.getAbsolutePath());
                    this.dir.add(f1);
                } else {
                    if (f.getName().toString().contains(".txt")) this.txt.add(f);
                    else this.other.add(f);
                }
            }
        }
    }

    public String getFileList(){
        StringBuilder builder = new StringBuilder();
        if (this.getDirectoriesList() != null) builder.append("Папки:\n" + this.getDirectoriesList());
        if (this.getTextFilesList() != null) builder.append("Текстовые файлы:\n" + this.getTextFilesList());
        if (this.getOtherFilesList() != null) builder.append("Другие файлы:\n" + this.getOtherFilesList());
        if (builder.toString().equals(""))  builder.append("Эта папка пуста.\n0. Вернуться предыдущей папке\n\n");
        return builder.toString();
    }
    public String getDirectoriesList(){
        StringBuilder builder = new StringBuilder("");
        int i = 1;
        for(FileDirectory f: this.dir){
            builder.append(i + ". " + f.getName() + "\n");
            i++;
        }
        if (builder.toString().equals("")) return null;
        else return builder.toString();
    }
    public String getTextFilesList(){
        StringBuilder builder = new StringBuilder("");
        int i = 1;
        for(File f: this.txt){
            builder.append(i + ". " + f.getName() + "\n");
            i++;
        }
        if (builder.toString().equals("")) return null;
        else return builder.toString();
    }
    public String getOtherFilesList(){
        StringBuilder builder = new StringBuilder("");
        int i = 1;
        for(File f: this.other){
            builder.append(i + ". " + f.getName() + "\n");
            i++;
        }
        if (builder.toString().equals("")) return null;
        else return builder.toString();
    }

    public String showInDirectory(int i) {
        if (goIn(i) == null) return null;
        else return this.goIn(i).getFileList();
    }
    public FileDirectory goIn(int i){
        if ((i > dir.size()) || (i < 1)){
            System.out.println("Папки с таким номером не существует.");
            return null;
        }
        else return this.dir.get(i-1);
    }

    public FileDirectory goBack(){
        if (this == root) return this;
        else{
            String s = this.getAbsolutePath();
            Pattern p = Pattern.compile("(\\\\)");
            Matcher m = p.matcher(s);
            int i = 0;
            while (m.find()) {
                i = m.end(1);
            }
            return new FileDirectory(s.substring(0,i-1));
        }
    }

   /*public static String addNote(){
        Scanner s = new Scanner(System.in);
        s
    }*/
}
