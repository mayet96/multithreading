package test;


import org.junit.Test;
import ru.id61890868.helper.NumParser;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class NumParserTest {

    @Test
    public void parse() throws Exception {
        assertEquals(NumParser.parse("one thousand two hundred ninety-eight"), new Integer(1298));
        assertEquals(NumParser.parse("Seven hundred fifty four"), new Integer(754));
        assertEquals(NumParser.parse("Sixty"), new Integer(60));
        assertEquals(NumParser.parse("three"), new Integer(3));
        assertEquals(NumParser.parse("zero"), new Integer(0));
        assertEquals(NumParser.parse("Nine thousand eleven"), new Integer(9011));

    }

    @Test
    public void findIndex() throws Exception {
        Integer[] array = {0,1,2,3,4,5,6,7,8,9,0};
        Integer obj = 4;

        Integer result = NumParser.findIndex(array, obj);

        assertNotNull(result);
        assertEquals(result, obj);
    }

    @Test
    public void toSingle(){
        assertEquals(NumParser.toSingle("words"), "word");
        assertEquals(NumParser.toSingle("wordss"), "words");
        assertEquals(NumParser.toSingle(" dasajd s"), " dasajd ");
    }
}