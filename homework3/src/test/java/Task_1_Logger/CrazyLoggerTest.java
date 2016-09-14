package Task_1_Logger;

import org.junit.Test;

public class CrazyLoggerTest {
    CrazyLogger logger = new CrazyLogger();

    @Test
    public void Add3Logs(){
        logger.addLog("First log\n");
        logger.addLog("Second log\n");
        logger.addLog("Third log\n");
        System.out.println(logger.getBuilder().toString());
    }

    @Test
    public void FindExistDayTest(){
        logger.addLog("First log\n");
        logger.addLog("Second log\n");
        logger.addLog("Third log\n");
        String day = "14-09-2016";
        logger.findDay(day);
    }

    @Test
    public void FindNonexistentDayTest(){
        logger.addLog("First log\n");
        logger.addLog("Second log\n");
        logger.addLog("Third log\n");
        String day = "13-09-2016";
        logger.findDay(day);
    }

    @Test
    public void FindExistWordTest(){
        logger.addLog("First log\n");
        logger.addLog("Second log\n");
        logger.addLog("Third log\n");
        String word = "log";
        logger.findWord(word);
    }

    @Test
    public void FindNonExistWordTest(){
        logger.addLog("First log\n");
        logger.addLog("Second log\n");
        logger.addLog("Third log\n");
        String word = "lol";
        logger.findWord(word);
    }
 }
