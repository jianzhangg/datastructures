package train;

/**
 * @author: jian.zhangg
 * @date: 19-3-16 上午8:32
 * @version: V1.0
 * @Description: 顶点信息
 */
public class Vertext {

    // 顶点名称
    private Character[] name;

    // 此属性后来决定用hashmap存更能提高效率  把数组查找中O(n)降为O(1) 限于在领接矩阵中实现
    // 顶点在顶点数组中的下标
//    private int index;

    // 根顶点到此顶点的距离
    private Integer distance;

    // 根顶点到此顶点的路径
    private String road;
}
