package train;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: jian.zhangg
 * @date: 19-3-16 下午8:57
 * @version: V1.0
 * @Description: 运行主类
 */
public class Main {
    public static void main(String[] args) {
        List<Vertex> vertices = new ArrayList<>();
        Vertex A = new Vertex('A');
        Vertex B = new Vertex('B');
        Vertex C = new Vertex('C');
        vertices.add(A);
        vertices.add(B);
        vertices.add(C);
        Map<Vertex, List<Edge>> vertexListHashMap = new HashMap<>();
        List<Edge> AEdge = new ArrayList<>();
        List<Edge> BEdge = new ArrayList<>();
        Edge AB = new Edge(A, B, 1);
        Edge AC = new Edge(A, C, 5);
        Edge BC = new Edge(B, C, 2);
        AEdge.add(AB);
        AEdge.add(AC);
        BEdge.add(BC);
        vertexListHashMap.put(A, AEdge);
        vertexListHashMap.put(B, BEdge);
        WeightDirectedGraphByList weightDirectedGraphByList = new WeightDirectedGraphByList(vertices, vertexListHashMap);
        A.getRoute().setDistance(0);
        new DijkstraAlgorithm().dijkstraAlgorithm(A,weightDirectedGraphByList);
        System.out.println(weightDirectedGraphByList);
    }
}
