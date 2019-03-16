package train;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author: jian.zhangg
 * @date: 19-3-16 下午8:59
 * @version: V1.0
 * @Description: 戴克斯特拉算法
 */
public class DijkstraAlgorithm {

    // 距离最大值最大值
    public static final Integer MAX = Integer.MAX_VALUE;

    // 用于存放已访问过的顶点
    private HashSet<Vertex> visited = new HashSet<>();

    public void dijkstraAlgorithm(Vertex root, WeightDirectedGraphByList graph) {

        // 这句话应该放在外面
        // 初始化root节点位开始节点
//        root.getRoute().setDistance(0);

        // 递归终止条件,如果root为空
        if (root == null || visited.contains(root) || Objects.isNull(graph.getVertexEdgeMap().get(root))) return;

        // 将已遍历的放入visited中
        visited.add(root);

        // 已经通过赋默认值省略这段代码
        // 默认将跟root没有关联的顶点距离设置为MAX
/*        graph.getVertexList().forEach(vertext -> {
            if (Objects.isNull(vertext.getRoute().getDistance())) {
                vertext.getRoute().setDistance(MAX);
            }
        });*/

        // 将跟root关联的节点距离设置为对应的权重
        graph.getVertexEdgeMap().get(root).forEach(edge -> {
            Vertex startVertex = edge.getStartVertex();
            Vertex endVertex = edge.getEndVertex();
            Route endVertextRoute = endVertex.getRoute();
            // 如果AC距离>AB+BC  那么把AC的距离和路径都调成AB+BC
            if (endVertextRoute.getDistance() > startVertex.getRoute().getDistance() + edge.getWeights()) {
                endVertextRoute.setDistance(startVertex.getRoute().getDistance() + edge.getWeights());
                endVertextRoute.getEdges().addAll(startVertex.getRoute().getEdges());
                endVertextRoute.getEdges().add(edge);

                // 用于处理第一次起点边上的点的处理  即保证第一次路径拼接不为null
                String startRoad = startVertex.getRoute().getRoad();
                if (startRoad == null) {
                    endVertextRoute.setRoad(startVertex.getName() + endVertex.getName().toString());
                } else {
                    endVertextRoute.setRoad(startVertex.getRoute().getRoad() + endVertex.getName().toString());
                }
            }
            dijkstraAlgorithm(endVertex, graph);
        });
    }

}
