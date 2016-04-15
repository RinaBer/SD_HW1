package graph;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rina.berlin on 4/14/2016.
 */
public class NodeTest {

    @Test
    public void testEquals(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        assert(n1.equals(n2) == false);
        assert(n2.equals(n1) == false);
        Node n3 = new Node(1);
        assert(n1.equals(n3) == true);
        assert(n1.hashCode() == n3.hashCode());
    }

    @Test
    public void testIncDecInDegree(){
        Node n = new Node(1);
        assert (n.getInDegree() == 0);
        n.incInDegree();
        assert (n.getInDegree() == 1);
        for (int i=0; i<2; i++) {
            n.decInDegree();
            assert (n.getInDegree() == 0);
        }
    }

    @Test
    public void testGetAndAddNeighbors(){
        Node n = new Node(1);
        assert(n.getNeighbors().size() == 0);
        n.addNeighbor(2);
        assert(n.getNeighbors().size() == 1);
    }
}