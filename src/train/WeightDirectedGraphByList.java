package train;

import java.util.List;
import java.util.Map;

/**
 * @author: jian.zhangg
 * @date: 19-3-16 上午8:48
 * @version: V1.0
 * @Description: 用领接表实现带权重的有向图
 */
public class WeightDirectedGraphByList {

    // 图中的所有顶点数组
    private List<Vertext> vertextList;

    // 每个节点拥有的边的信息
    private Map<Vertext,Edge> vertextEdgeMap;

    public WeightDirectedGraphByList(List<Vertext> vertextList, Map<Vertext, Edge> vertextEdgeMap) {
        this.vertextList = vertextList;
        this.vertextEdgeMap = vertextEdgeMap;
    }
}
