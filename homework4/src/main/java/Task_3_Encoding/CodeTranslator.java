package Task_3_Encoding;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CodeTranslator {
    String text ;

    CodeTranslator(){
        text = readText();
    }

    private String readText() {
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream("task_3_text.txt"), "utf8");
            char b[] = new char [500];
            int k;
            int i = 0;
            while ((k = isr.read()) != -1) {
                b[i] = (char)k;
                i++;
            }
            isr.close();
            System.out.println(b.toString());
            return b.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String Write16Text(){
        try {
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("task_3_text16.txt"), "utf16");
            osw.write(text);
            osw.close();
            System.out.println(osw.toString());
            return osw.toString();
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

