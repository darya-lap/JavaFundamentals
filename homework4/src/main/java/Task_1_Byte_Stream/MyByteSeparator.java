package Task_1_Byte_Stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

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
                code.append(s);
                code.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  /*  public int findWords() {
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
        System.out.println(words.toString());
        return counter;
    }

    public String getListOfWords(){
        return words.toString();
    }*/
}
