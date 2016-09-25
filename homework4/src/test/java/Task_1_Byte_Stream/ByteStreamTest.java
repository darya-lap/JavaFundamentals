package Task_1_Byte_Stream;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ByteStreamTest {

    @Test
    public void SeparateWords(){
        MyByteSeparator separator = new MyByteSeparator();
        int count = separator.findWords();
        separator.writeWords();
        assertEquals(count,32);
        assertThat(separator.getListOfWords(), containsString ("int"));
    }
}
