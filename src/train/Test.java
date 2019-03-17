package train;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @Author: 张健
 * @CreateDate: 2019-03-17 16:55
 * @Version: 1.0
 * @Description:测试题内容
 */
public class Test {

    private Algorithm algorithm = new Algorithm();

    /**
     * 理解： 1-5题是比较简单的根据路程算距离，解决方法非常多，我甚至想到了用数据库
     * 实现： 1. 用for循环遍历的时间复杂度为O(e1*e2) e1为总边数 e2为要求个边数
     * 2. 也可以用两点间所有路程求解，算第一个顶点到最后一个顶点的所有路径，再和给予的参数比。
     */
    public String question1_5(List<Edge> edges, WeightDirectedGraphByList weightDirectedGraphByList) {
        return algorithm.getDistanceByRoute(edges, weightDirectedGraphByList);
    }

    /**
     * 理解： 6-10题其实是同一类问题，这类问题的核心是算出图中任意两点之间的路途信息
     * 然后再对结果做筛选
     */
    public Integer question6(Vertex startVertex, Vertex endVertex, WeightDirectedGraphByList weightDirectedGraphByList) {
        List<Route> allRoutes = algorithm.getAllRoutes(startVertex, endVertex, weightDirectedGraphByList);
        return allRoutes.stream()
                .filter(e -> e.getEdges().size() < 4)
                .collect(Collectors.toList())
                .size();
    }


    /**
     * 这题里面有个可重复问题，比如CD可以来回跑。。。  没get到这里怎么处理比较好
     */
    public Integer question7(Vertex startVertex, Vertex endVertex, WeightDirectedGraphByList weightDirectedGraphByList) {
        List<Route> allRoutes = algorithm.getAllRoutes(startVertex, endVertex, weightDirectedGraphByList);
        return allRoutes.stream()
                .filter(e -> e.getEdges().size() == 4)
                .collect(Collectors.toList())
                .size();
    }

    public Integer question8(Vertex startVertex, Vertex endVertex, WeightDirectedGraphByList weightDirectedGraphByList) {
        List<Route> allRoutes = algorithm.getAllRoutes(startVertex, endVertex, weightDirectedGraphByList);
        return allRoutes.stream()
                .map(Route::getDistance)
                .reduce(Integer.MAX_VALUE, Integer::min);
    }

    public Integer question9(Vertex startVertex, Vertex endVertex, WeightDirectedGraphByList weightDirectedGraphByList) {
        List<Route> allRoutes = algorithm.getAllRoutes(startVertex, endVertex, weightDirectedGraphByList);
        return allRoutes.stream()
                .map(Route::getDistance)
                .reduce(Integer.MAX_VALUE, Integer::min);
    }

    /**
     * 理解： 这个问题最后可以转化为在一个数组中挑选元素，元素可重复，但挑出来的元素的和要小于30
     * 用while排序死活没搞出来。。。
     */
    public Integer question10(Vertex startVertex, Vertex endVertex, WeightDirectedGraphByList weightDirectedGraphByList) {
        List<Route> allRoutes = algorithm.getAllRoutes(startVertex, endVertex, weightDirectedGraphByList);
        List<Integer> sortedRouteDistances = allRoutes.stream()
                .map(Route::getDistance)
                .sorted()
                .collect(Collectors.toList());
        Stack<Integer> stack = new Stack<>();
        Integer i = 0;
       /*while (sumStack(stack)<=30){
           stack.push(sortedRouteDistances.get(0));
       }*/
        return -1;
    }

    private Integer sumStack(Stack<Integer> stack) {
        return stack.stream()
                .reduce(0, Integer::sum);
    }

    private Integer getStack(Stack<Integer> stack) {
        return stack.stream()
                .reduce(0, Integer::sum);
    }


}
