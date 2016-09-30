package Task_1_File_Directory;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileDirectory extends File {

    private ArrayList<FileDirectory> dir;
    private ArrayList<File> txt ;
    private ArrayList<File> other;
    private static FileDirectory root;
    {
        dir = null;
        txt = null;
        other = null;
        root = null;
    }
    FileDirectory(String path){
        super(path);
        if (this.exists()) {
            dir = new ArrayList<>();
            txt = new ArrayList<>();
            other = new ArrayList<>();
            sortFiles();
        }
    }

    public boolean startApp(){
        if (!this.exists()){
            return false;
        }
        else{
            this.setRoot();
            return true;
        }
    }

    public void setRoot(){
        root = this;
    }

    public ArrayList<File> getTxt(){
        return this.txt;
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
        try{
            return this.goIn(i).getName();
        }
        catch(FileNotFoundException e){
            return null;
        }
    }
    public FileDirectory goIn(int i) throws FileNotFoundException{
        if ((i > dir.size()) || (i < 1)){
            throw new FileNotFoundException("Папки с таким номером не существует.");
        }
        else return this.dir.get(i-1);
    }

    public FileDirectory goBack() throws FileNotFoundException{
        if (this == root) {
            throw new FileNotFoundException("Вы в корневой папке!");
        }
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

    public void createTextFile(){
        System.out.println("Введите имя файла:");
        File textFile = null;
        BufferedReader scan = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder text = new StringBuilder();
        try {
            String fileName = scan.readLine();
            System.out.println("Введите содержимое файла (чтобы закончить запись, введите \"End of the text\":\n");
            textFile = new File(this.getAbsolutePath() + "\\" + fileName + ".txt");
            String b;
            while (!((b = scan.readLine()).equals("End of the text"))){
                text.append(b + "\n");
            }
            scan.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(textFile)))){
            pw.write(text.toString());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        this.txt.add(textFile);
    }
    public void editTextFile(){
        System.out.println("Введите номер файла:");
        BufferedReader scan = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder text = new StringBuilder();
        File textFile = null;
        try {
            textFile = txt.get(Integer.parseInt(scan.readLine())-1);
            StringBuilder str = getConsistOfTextFile(textFile);
            System.out.println("Введите содержимое файла (чтобы закончить запись, введите \"End of the text\":\n");
            String b;
            while (!((b = scan.readLine()).equals("End of the text"))){
                text.append(b + "\n");
            }
            scan.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(textFile)))){
            pw.write(text.toString());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        this.txt.add(textFile);

    }
    public StringBuilder getConsistOfTextFile(File f) {
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            StringBuilder str = new StringBuilder();
            int s;
            while ((s = br.read()) != -1) {
                str.append((char)s);
            }
            System.out.println(str.toString());
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
    public String setText(){

    }

    public static void main(String ... args) {
        FileDirectory fileDirectory = new FileDirectory("H:\\Java-EPAM");
        //fileDirectory.createTextFile();
        fileDirectory.editTextFile();
    }
}
