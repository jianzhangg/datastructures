package train;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jian.zhangg
 * @date: 19-3-16 下午8:54
 * @version: V1.0
 * @Description: 路途类  包括路程所有节点和距离  所有属性都会用到所有赋默认值不会造成内存浪费
 */
public class Route {
    // 到初始顶点所有的路程
    private List<Edge> edges = new ArrayList<>();

    // 经历的路程
    private String road;

    // 路途的总距离
    private Integer distance = DijkstraAlgorithm.MAX;

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
