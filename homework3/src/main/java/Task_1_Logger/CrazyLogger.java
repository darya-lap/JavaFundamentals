package Task_1_Logger;

import java.util.Calendar;
import java.util.Formatter;

public class CrazyLogger {
    private StringBuilder builder = new StringBuilder();

    public void addLog(String str){
        Calendar calendar = Calendar.getInstance();
        Formatter formatter = new Formatter();
        formatter.format("%1$td-%1$tm-%1$tY : %1$tH-%1$tM-", calendar);
        builder.append(formatter);
        builder.append(str);
    }

    public String getBuilder(){
        return builder.toString();
    }

    public void findDay(String day){
        int flagIndex = 0;
        int endIndex = 0;
        int beginIndex = builder.indexOf(day,flagIndex);
        if (beginIndex < 0) System.out.println("У вас нет сообщений, удовлетворяющих поиску :(\n");
        else {
            while ((endIndex < builder.length()) && (beginIndex >= 0)) {
                beginIndex = builder.indexOf(day, flagIndex);
                endIndex = beginIndex;
                while (builder.charAt(endIndex) != '\n') {
                    endIndex++;
                }
                String sub = builder.substring(beginIndex, endIndex);
                System.out.println(sub);
                flagIndex = endIndex++;
            }
        }
    }

    public void findWord(String word) {
        int flagIndex = 0;
        int endIndex = 0;
        int beginIndex = builder.indexOf(word, flagIndex);
        if (beginIndex < 0) System.out.println("У вас нет сообщений, удовлетворяющих поиску :(\n");
        else {
            while ((endIndex < builder.length()) && (beginIndex >= 0)) {
                beginIndex = builder.indexOf(word, flagIndex);
                endIndex = beginIndex;
                while (builder.charAt(endIndex) != '\n') {
                    endIndex++;
                }
                while ((builder.charAt(beginIndex) != '\n') && (beginIndex > 0)) {
                    beginIndex--;
                }
                if (beginIndex != 0) beginIndex++;
                String sub = builder.substring(beginIndex, endIndex);
                System.out.println(sub);
                flagIndex = endIndex++;
            }
        }
    }
}
