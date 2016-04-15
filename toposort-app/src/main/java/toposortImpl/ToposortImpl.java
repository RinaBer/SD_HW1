package toposortImpl;

import com.google.inject.Inject;
import cs.technion.ac.il.sd.External;
import cs.technion.ac.il.sd.app.Toposort;
import graph.Graph;
import graph.Node;
import parser.Parser;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by rina.berlin on 4/11/2016.
 */
public class ToposortImpl implements Toposort {
    private final External external;

    @Inject
    public ToposortImpl(External external) {
        this.external = external;
    }

    @Override
    public void processFile(File file) {
        Graph graph = Parser.parse(file);
        while (!graph.isEmpty()){
            Optional<Node> source = graph.getSource();
            Node node;
            try {
                 node = source.get();
            } catch( NoSuchElementException e){
                external.fail();
                return;
            }
            graph.removeVertex(node);
            external.process(node.getVertexID());
        }
    }
}
