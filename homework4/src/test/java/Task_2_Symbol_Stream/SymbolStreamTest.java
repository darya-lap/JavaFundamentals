package Task_2_Symbol_Stream;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;

public class SymbolStreamTest {

    @Test
    public void SeparateWords(){
        MySymbolSeparator separator = new MySymbolSeparator();
        int count = separator.findWords();
        separator.writeWord();
        assertEquals(count,32);
        assertThat(separator.getListOfWords(), containsString ("int"));
    }
}
