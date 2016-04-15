package parser;

import graph.Edge;
import graph.Graph;
import javafx.util.Pair;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by rina.berlin on 4/11/2016.
 */
public class Parser {
    public static Graph parse(File file) {
        HashSet<Integer> vertexes = new HashSet<>();
        HashSet<Edge> edges = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null) {
                int[] lineArr = Arrays.asList(line.split("->")).stream().mapToInt(Integer::parseInt).toArray();
                for (int v : lineArr){
                    vertexes.add(v);
                }
                if (lineArr.length > 1){
                    edges.add(new Edge(lineArr[0], lineArr[1]));
                }
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return new Graph(vertexes, edges);
    }
}
