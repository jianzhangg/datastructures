package train;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: jian.zhangg
 * @date: 19-3-16 上午8:48
 * @version: V1.0
 * @Description: 用领接表实现带权重的有向图
 */
public class WeightDirectedGraphByList {

    // 图中的所有顶点数组
    private List<Vertex> vertexList;

    // 每个节点拥有的边的信息
    private Map<Vertex, List<Edge>> vertexEdgeMap;

    public WeightDirectedGraphByList(List<Vertex> vertexList, Map<Vertex, List<Edge>> vertexEdgeMap) {
        this.vertexList = vertexList;
        this.vertexEdgeMap = vertexEdgeMap;
    }

    public WeightDirectedGraphByList(List<Edge> edges) {
        this.vertexEdgeMap = edges.stream()
                .collect(Collectors.groupingBy(Edge::getStartVertex));
        this.vertexList = new ArrayList<>(vertexEdgeMap.keySet());
    }

    public List<Vertex> getVertexList() {
        return vertexList;
    }

    public void setVertexList(List<Vertex> vertexList) {
        this.vertexList = vertexList;
    }

    public Map<Vertex, List<Edge>> getVertexEdgeMap() {
        return vertexEdgeMap;
    }

    public void setVertexEdgeMap(Map<Vertex, List<Edge>> vertexEdgeMap) {
        this.vertexEdgeMap = vertexEdgeMap;
    }
}
