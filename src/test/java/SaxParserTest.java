import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.abramov.tests_middle.SaxParser;
import ru.abramov.tests_middle.models.Entity;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SaxParserTest {
    SaxParser saxParser;
    @Before
    public void init() {
        saxParser= new SaxParser();
        System.out.println("init SaxParser");
    }

    @After
    public void clear() {
        saxParser = null;
    }

    @Test
    public void testGame() {
         saxParser.parse("files/for/parsing/xml/template.xml");
        ArrayList<Entity> entities = saxParser.getEntities();
        assertEquals(7910, entities.size());
    }


}
