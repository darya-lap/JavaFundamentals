package Task_3_Encoding;

import org.junit.Test;

public class EncodingTest {

    @Test
    public void CreateTranslator(){
        CodeTranslator translator = new CodeTranslator();
        translator.Write16Text();
    }
}
