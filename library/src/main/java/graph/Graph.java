package graph;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by rina.berlin on 4/11/2016.
 */

public class Graph {
    private HashSet<Node> vertexes;

    public Graph(HashSet<Integer> vertexes, HashSet<Edge> edges){
        this.vertexes = new HashSet<Node>();
        for (Integer v : vertexes) {
            addVertex(v);
        }
        for (Edge e : edges) {
            try {
                addEdge(e);
            } catch (Exception exp){
                System.out.println(exp.getMessage());
            }
        }
    }
    private void addVertex(Integer v){
        Node node = new Node(v);
        vertexes.add(node);
    }
    private void addEdge(Edge edge) throws Exception{
        Optional<Node> source = vertexes.stream().filter(node->node.getVertexID().equals(edge.getSource())).findFirst();
        Optional<Node> target = vertexes.stream().filter(node->node.getVertexID().equals(edge.getTarget())).findFirst();
        try {
            source.get().addNeighbor(edge.getTarget());
            target.get().incInDegree();
        } catch (NullPointerException e){
            throw new Exception("node wasn't found in add edge");
        }
    }

    public void removeVertex(Node node){
        List<Integer> list = node.getNeighbors();
        vertexes = vertexes.stream().map(v-> {if(list.contains(v.getVertexID())) v.decInDegree(); return v;}).
                collect(Collectors.toCollection(HashSet<Node>::new));
        vertexes.remove(node);
    }

    public Optional<Node> getSource(){
        Optional<Node> s = vertexes.stream().filter(node->node.getInDegree() == 0).findFirst();
        return s;
    }

    public Boolean isEmpty(){
        return vertexes.isEmpty();
    }
}
