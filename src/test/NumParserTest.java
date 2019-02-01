package test;

import org.junit.Assert;
import org.junit.Test;
import ru.id61890868.helper.NumParser;

import static org.junit.Assert.*;

public class NumParserTest {

    @Test
    public void parse() throws Exception {
        System.out.println(NumParser.parse("Nine thousand nine hundred ninety nine"));
        System.out.println(NumParser.parse("nine hundred ninety nine"));
    }

    @Test
    public void findIndex() throws Exception {
        Integer[] array = {0,1,2,3,4,5,6,7,8,9,0};
        Integer obj = 4;

        Integer result = NumParser.findIndex(array, obj);

        assertNotNull(result);
        assertEquals(result, obj);
    }
}