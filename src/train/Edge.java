package train;

import java.util.Objects;

/**
 * @author: jian.zhangg
 * @date: 19-3-16 上午8:40
 * @version: V1.0
 * @Description: 边的属性
 */
public class Edge {
    // 边的起始节点
    private Vertex startVertex;

    // 边的结束节点
    private Vertex endVertex;

    // 边的权重  可以理解为从start到end的距离
    private Integer weights;

    public Edge(Vertex startVertex, Vertex endVertex, Integer weights) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weights = weights;
    }

    public Edge(Vertex startVertex, Vertex endVertex) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }

    public void setEndVertex(Vertex endVertex) {
        this.endVertex = endVertex;
    }

    public Integer getWeights() {
        return weights;
    }

    public void setWeights(Integer weights) {
        this.weights = weights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(startVertex, edge.startVertex) &&
                Objects.equals(endVertex, edge.endVertex) &&
                Objects.equals(weights, edge.weights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startVertex, endVertex, weights);
    }
}
