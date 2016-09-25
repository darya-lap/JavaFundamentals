package Task_1_Byte_Stream;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyByteSeparator {
    StringBuilder code;
    StringBuilder words;

    MyByteSeparator(){
        readCode();
    }
    private void readCode() {
        code = new StringBuilder("");
        try {
            FileInputStream in = new FileInputStream("H:\\JavaProjects\\JavaFundamentals\\homework3\\src\\main\\java\\Task_1_Logger\\CrazyLogger.java");
            BufferedInputStream bw = new BufferedInputStream(in);
            int s;
            while ((s = bw.read()) != -1) {
                code.append((char)s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int findWords() {
        this.words = new StringBuilder("");
        Pattern p1 = Pattern.compile("([a-z]+)\\s");
        Matcher m = p1.matcher(code);
        Pattern p = Pattern.compile("\\s([a-z]+)\\s[^=;]");
        int counter = 0;
        int start = 0;
        if (m.find(start)){
            counter++;
            this.words.append(m.group(1).toString());
            this.words.append("\n");
            start = m.end(1);
        }
        m = p.matcher(code);
        while (m.find(start)) {
            counter++;
            if (this.words.indexOf(m.group(1).toString()) == -1) {
                words.append(m.group(1).toString());
                words.append("\n");
            }
            start = m.end(1);
        }
        System.out.println(words.toString());
        return counter;
    }

    public String getListOfWords(){
        return words.toString();
    }

    public void writeWords() {
        try {
            FileOutputStream fs = new FileOutputStream("H:\\Java-EPAM\\HW4_task_2_byte.txt");
            BufferedOutputStream bs = new BufferedOutputStream(fs);
            DataOutputStream ds = new DataOutputStream(bs);

            Pattern p = Pattern.compile("[^\n]([a-z]+)");
            Matcher m = p.matcher(words);
            while (m.find()) {
                byte[] bytes = m.group(0).toString().getBytes();
                ds.write(bytes,0,bytes.length);
                ds.write('\r');
                ds.write('\n');
            }
            ds.write(this.findWords());
            ds.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
