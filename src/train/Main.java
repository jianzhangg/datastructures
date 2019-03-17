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
/*        List<Vertex> vertices = new ArrayList<>();
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
        A.getRoute().setDistance(0);*/
//        new Algorithm().dijkstraAlgorithm(A,weightDirectedGraphByList);

        List<Edge> edges = new ArrayList<>();
        Vertex A = new Vertex('A');
        Vertex B = new Vertex('B');
        Vertex C = new Vertex('C');
        Vertex D = new Vertex('D');
        Vertex E = new Vertex('E');
        Edge AB5 = new Edge(A,B,5);
        Edge BC4 = new Edge(B,C,4);
        Edge CD8 = new Edge(C,D,8);
        Edge DC8 = new Edge(D,C,8);
        Edge DE6 = new Edge(D,E,6);
        Edge AD5 = new Edge(A,D,5);
        Edge CE2 = new Edge(C,E,2);
        Edge EB3 = new Edge(E,B,3);
        Edge AE7 = new Edge(A,E,7);
        edges.add(AB5);
        edges.add(BC4);
        edges.add(CD8);
        edges.add(DC8);
        edges.add(DE6);
        edges.add(AD5);
        edges.add(CE2);
        edges.add(EB3);
        edges.add(AE7);
        WeightDirectedGraphByList weightDirectedGraphByList = new WeightDirectedGraphByList(edges);

        List<Route> allRoutes = new Algorithm().getAllRoutes(B, B, weightDirectedGraphByList);
        allRoutes.forEach(route -> {
            System.out.println(route.getRoad());
        });
    }
}
