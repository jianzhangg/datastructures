package train;

/**
 * @author: jian.zhangg
 * @date: 19-3-16 上午8:32
 * @version: V1.0
 * @Description: 顶点信息
 */
public class Vertex {

    // 顶点名称
    private Character name;

    // 此属性后来决定用hashmap存更能提高效率  把数组查找中O(n)降为O(1) 限于在领接矩阵中实现
    // 顶点在顶点数组中的下标
//    private int index;

    // 起始点到该顶点的路程  给予初始值 因为每个节点都是必要的  不会涉及到内存浪费
    private Route route = new Route();

    public Vertex(Character name) {
        this.name = name;
    }

    public Character getName() {
        return name;
    }

    public void setName(Character name) {
        this.name = name;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
