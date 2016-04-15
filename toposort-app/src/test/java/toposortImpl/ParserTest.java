package toposortImpl;

import graph.Graph;
import org.junit.Test;
import parser.Parser;

import java.io.File;

/**
 * Created by rina.berlin on 4/12/2016.
 */
public class ParserTest {

    @Test
    public void testParser(){
        File f = new File("C:\\Users\\Rina.Berlin\\Desktop\\Toposort-skeleton" +
                "\\Toposort-308044395-308025394\\toposort-test\\target\\test-classes\\large_graph.txt");
        Graph g = Parser.parse(f);
    }
}