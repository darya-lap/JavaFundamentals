package Task_2_Map;

import org.junit.Test;

import java.util.Locale;

import static junit.framework.TestCase.assertEquals;

public class UniversalPropertiesMapTest {

    @Test
    public void TryToCreateMap(){
        UniversalPropertiesMap upm = new UniversalPropertiesMap();
        assertEquals(upm.getResourse(new Locale("fr_FR"), 1), "Je suis proprit fr_FR");

    }
}
