package Task_2_Locale_ResourceBundle;

import org.junit.Test;

import java.util.Locale;

import static junit.framework.TestCase.assertEquals;

public class Locale_ResourseBundle_test {
    private ResourceProperty bundle;

    @Test
    public void ENLocaleQuestionsToOut() throws Exception{
        bundle = new ResourceProperty(new Locale("en", "US"));
        assertEquals(bundle.getAllQuestions(),"1. What is the capital of Great Britain?\n" +
                "2. A little girl kicks a soccer ball. It goes 10 feet and comes back to her. How is this possible?\n" +
                "3. A is the father of B. But B is not the son of A. How's that possible?\n" +
                "4. How can a man go eight days without sleep?");
    }

    @Test
    public void ENLocaleQuestion1() throws Exception {
        bundle = new ResourceProperty(new Locale("en", "US"));
        assertEquals(bundle.getAnswer(1), "London is the capital of Great Britain.");
    }

    @Test
    public void ENLocaleQuestion2() throws Exception {
        bundle = new ResourceProperty(new Locale("en", "US"));
        assertEquals(bundle.getAnswer(2), "Ever heard of gravity? She kicked it up.");
    }

    @Test
    public void ENLocaleQuestion3() throws Exception {
        bundle = new ResourceProperty(new Locale("en", "US"));
        assertEquals(bundle.getAnswer(3), "B is the daughter you MCP's!");
    }

    @Test
    public void ENLocaleQuestion4() throws Exception {
        bundle = new ResourceProperty(new Locale("en", "US"));
        assertEquals(bundle.getAnswer(4), "By sleeping during the night time.");
    }

    @Test
    public void RULocaleQuestion1() throws Exception {
        bundle = new ResourceProperty(new Locale("ru", "RU", "WINDOWS"));
        assertEquals(bundle.getAnswer(1), "Столица Великобритании - Лондон.");
    }

    @Test
    public void RULocaleQuestion2() throws Exception {
        bundle = new ResourceProperty(new Locale("ru", "RU", "WINDOWS"));
        assertEquals(bundle.getAnswer(2), "Никогда не слышали про гравитацию? Она пнула его вверх.");
    }

    @Test
    public void RULocaleQuestion3() throws Exception {
        bundle = new ResourceProperty(new Locale("ru", "RU", "WINDOWS"));
        assertEquals(bundle.getAnswer(3), "Б - это дочь, гендерные дискриминаторы!");
    }

    @Test
    public void RULocaleQuestion4() throws Exception {
        bundle = new ResourceProperty(new Locale("ru", "RU", "WINDOWS"));
        assertEquals(bundle.getAnswer(4), "Ему просто нужно спать по ночам, вот и всё.");
    }

}
