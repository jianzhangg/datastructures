package train;

import java.util.*;

/**
 * @author: jian.zhangg
 * @date: 19-3-16 下午8:59
 * @version: V1.0
 * @Description: 解题涉及到的所有算法
 */
public class Algorithm {

    // 距离最大值最大值
    public static final Integer MAX = Integer.MAX_VALUE;

    // 用于存放已访问过的顶点
    private HashSet<Vertex> visitedVertex = new HashSet<>();

    // 用于存放已访问过的边
    private HashSet<Edge> visitedEdge = new HashSet<>();

    // 用于存放所有两点间的路程
    private List<Route> routes = new ArrayList<>();

    /**
     * 戴克斯特拉算法  计算图中一顶点到其他顶点的距离
     * 贪心算法+深度优先
     *
     * @param root  初始节点
     * @param graph 节点所在的图
     */
    public void dijkstraAlgorithm(Vertex root, WeightDirectedGraphByList graph) {

        // 这句话应该放在外面
        // 初始化root节点位开始节点
//        root.getRoute().setDistance(0);

        // 递归终止条件,root为空/root已经访问过/root没有边了
        if (root == null || visitedVertex.contains(root) || Objects.isNull(graph.getVertexEdgeMap().get(root))) return;

        // 将已遍历的放入visited中
        visitedVertex.add(root);

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

    /**
     * 计算图中任意两点之间所有路程
     *
     * @param startVertex
     * @param endVertex
     * @param graph
     * @return
     */
    public List<Route> getAllRoutes(Vertex startVertex, Vertex endVertex, WeightDirectedGraphByList graph) {
        graph.getVertexEdgeMap().get(startVertex).forEach(edge -> {
            Stack<Edge> visitedVertex = new Stack<>();
            visitedVertex.push(edge);
            getAllRoutes(endVertex, visitedVertex, graph);
        });
        return routes;
    }

    private void getAllRoutes(Vertex endVertex, Stack<Edge> routeStack, WeightDirectedGraphByList graph) {
        if (Objects.isNull(endVertex) || routeStack.isEmpty()) return;

        Edge lastPeek = routeStack.peek();

        // 说明边的后续节点就是end
        if (Objects.equals(lastPeek.getEndVertex(), endVertex)) {
            routes.add(getRoute(routeStack));
            return;
        }

        // visited中最后一条edge的end节点的所有的edges
        List<Edge> edges = graph.getVertexEdgeMap().get(lastPeek.getEndVertex());

        for (Edge edge : edges) {
            if (!visitedEdge.contains(edge)) {
                // 后续节点不是end继续往下找
                routeStack.push(edge);
                visitedEdge.add(edge);
                getAllRoutes(edge.getEndVertex(), routeStack, graph);
            }
        }
    }

    /**
     * 通过stack组装route
     */
    private Route getRoute(Stack<Edge> routeStack) {
        Route route = new Route();

        // routeStack里面的edge顺着排就是route
        for (Edge e : routeStack) {
            route.getEdges().add(e);

            if (route.getDistance().equals(MAX)) {
                route.setDistance(e.getWeights());
            } else {
                route.setDistance(route.getDistance() + e.getWeights());
            }

            if (Objects.isNull(route.getRoad())) {
                route.setRoad(e.getStartVertex().getName().toString().concat(e.getEndVertex().getName().toString()));
            } else {
                route.setRoad(route.getRoad().concat(e.getEndVertex().getName().toString()));
            }
        }
        return route;
    }

}
