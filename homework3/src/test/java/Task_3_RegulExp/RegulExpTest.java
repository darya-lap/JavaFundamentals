package Task_3_RegulExp;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RegulExpTest {
    MySearch search = new MySearch();

    @Test
    public void AreImagesConsistent(){
        assertEquals(search.areImgConsistant(), false);
    }

    @Test
    public void SentenceWithImg(){
        search.sentenceWithImg();
    }
}
