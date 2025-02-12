import dev.thoq.Parser;
import dev.thoq.Utility;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ParserTest {
    @Test
    public void testParser() {
        String data = "test => hi";
        Map<String, String> result = Parser.parse(data);
        Map<String, String> expected = new HashMap<>();
        expected.put("test", "hi");

        assertEquals(expected, result);
    }

    @Test
    public void testParserMultiline() {
        String data = "test => line 1\n" +
                "> line 2\n" +
                "> line 3";
        Map<String, String> result = Parser.parse(data);
        Map<String, String> expected = new HashMap<>();
        expected.put("test", "line 1\nline 2\nline 3");

        assertEquals(expected, result);
    }

    @Test
    public void testCheckFileExtension() {
        String fileExtensionSrb = "test.srb";
        String fileExtensionSorbet = "test.sorbet";
        String fileExtensionTxt = "test.txt";

        assertTrue(Utility.checkFileExtension(fileExtensionSrb));
        assertTrue(Utility.checkFileExtension(fileExtensionSorbet));
        assertFalse(Utility.checkFileExtension(fileExtensionTxt));
    }
}
