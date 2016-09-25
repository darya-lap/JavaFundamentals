package Task_3_RegulExp;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String;

import static java.lang.Integer.parseInt;

public class MySearch {
    private String page = this.getPage();

    private String getPage(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            InputStream is = new FileInputStream(new File("H:\\Java-EPAM\\page.html"));
            int b;
            while ((b = is.read()) != -1) {
                baos.write(b);
            }
        }
        catch (Exception e){
            System.out.println("Error");
        }
        String s = new String();
        try {
            s = baos.toString("Cp1251");
        }
        catch (Exception e1){
            System.out.println("Error");
        }
        return s;
    }

    public boolean areImgConsistant(){
        Pattern p = Pattern.compile("\\(Рис. (\\d+)\\)");
        Matcher m = p.matcher(page);
        int numeration = 0;
        while (m.find()){
            if (m.start(0) < m.end(0)){
                Integer c = parseInt(m.group(1));
                if (c < numeration){
                    return false;
                }
                else{
                    numeration = c;
                }
            }
        }
        return true;
    }

    public void sentenceWithImg(){
        StringBuilder str = new StringBuilder(page);
        Pattern p = Pattern.compile("рисунке \\d+|\\(Рис. \\d+\\)|рис. \\d+");
        Pattern p1 = Pattern.compile("&nbsp;");
        Matcher m = p1.matcher(str);
        while (m.find()){
            int begin;
            try {
                begin = m.start(0);
            }
            catch(StringIndexOutOfBoundsException e){
                begin = 0;
            }
            int end;
            try {
                end = m.end(0);

            }
            catch(StringIndexOutOfBoundsException e){
                end = str.length();
            }
            str.delete(begin, end);
            m = p1.matcher(str);
        }
        m = p.matcher(str);
        while (m.find()){
            int begin;
            try {
                begin = m.start(0);
                while (('.' != str.charAt(begin)) &&
                        (begin != 0) &&
                        (str.charAt(begin) != '>') &&
                        (str.charAt(begin) != '?') &&
                        (str.charAt(begin) != '!')) {
                    begin--;
                }
                if (begin != 0) {
                    if (str.charAt(begin) == '>'){
                        begin++;
                    }
                    else {
                        begin += 2;
                    }
                }
            }
            catch(Exception e1){
                begin = 0;
            }
            int end;
            try {
                end = m.end(0);
                while (
                        (
                                ('.' != str.charAt(end)) && (end < str.length()) && (str.charAt(end) != '?')
                        )
                                ||
                        (
                                ('.' == str.charAt(end)) && (end + 1 < str.length())
                                        &&
                                ((str.substring(end-3,end) == "Рис.") || (str.substring(end-3,end) == "рис."))
                        )

                        ){
                    end++;
                }
                end++;
            }
            catch (StringIndexOutOfBoundsException e){
                end = str.length();
            }

            System.out.println(str.substring(begin, end));
        }
    }
}
