package Task_3_Encoding;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class EncodingTest {

    @Test
    public void CreateTranslator(){
        CodeTranslator translator = new CodeTranslator();
        assertEquals(translator.Write16Text(),"Я - считанный текст в utf8");
    }
}
