package Task_2_Symbol_Stream;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySymbolSeparator {
    StringBuilder code;
    StringBuilder words;

    MySymbolSeparator(){
        readCode();
    }
    private void readCode() {
        code = new StringBuilder("");
        try (BufferedReader bw = new BufferedReader(new FileReader("H:\\JavaProjects\\JavaFundamentals\\homework3\\src\\main\\java\\Task_1_Logger\\CrazyLogger.java"))){
            String s;
            while ((s = bw.readLine()) != null) {
                code.append(s);
                code.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int findWords() {
        words = new StringBuilder("");
        Pattern p1 = Pattern.compile("([a-z]+)\\s");
        Matcher m = p1.matcher(code);
        Pattern p = Pattern.compile("\\s([a-z]+)\\s[^=;]");
        int counter = 0;
        int start = 0;
        if (m.find(start)){
            counter++;
            words.append(m.group(1).toString());
            words.append("\n");
            start = m.end(1);
        }
        m = p.matcher(code);
        while (m.find(start)) {
            counter++;
            if (words.indexOf(m.group(1).toString()) == -1) {
                words.append(m.group(1).toString());
                words.append("\n");
            }
            start = m.end(1);
        }
        return counter;
    }

    public String getListOfWords(){
        return words.toString();
    }

    public void writeWord(){
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("HW4_task_2_symbols.txt")))){
            Pattern p = Pattern.compile("[^\n]([a-z]+)");
            Matcher m = p.matcher(words);
            while (m.find()) {
                pw.println(m.group(0).toString());
            }
            pw.println("count = " + this.findWords());
            pw.flush();
            pw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
