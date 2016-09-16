package Task_1_Logger;

import org.junit.Test;

public class CrazyLoggerTest {
    CrazyLogger logger = new CrazyLogger();

    public CrazyLoggerTest(){
        logger.addLog("First log\n");
        logger.addLog("Second log\n");
        logger.addLog("Third log\n");
    }

    @Test
    public void Add3Logs(){
        System.out.println(logger.getBuilder().toString());
    }

    @Test
    public void FindExistDayTest(){
        String day = "15-09-2016";
        logger.findDay(day);
    }

    @Test
    public void FindNonexistentDayTest(){
        String day = "13-09-2016";
        logger.findDay(day);
    }

    @Test
    public void FindExistWordTest(){
        String word = "log";
        logger.findWord(word);
    }

    @Test
    public void FindNonExistWordTest(){
        String word = "lol";
        logger.findWord(word);
    }
 }
