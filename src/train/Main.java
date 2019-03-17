package train;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jian.zhangg
 * @date: 19-3-16 下午8:57
 * @version: V1.0
 * @Description: 运行主类
 *
 * 理解： 火车路线这道题映射在生活中就是高德地图导航问题，比如中武汉到黄石怎么走最近，如果中途要经过加油站怎么走，什么路线距离最短、时间最短等等
 *
 * 解题过程： 电话通知后，只有3天时间解题。当时并不知道图论等。像这种结构主义的知识，从底层学的效率最高。所以一开始没有急着解题。
 *  这是我的时间分配：
 *  1. 第一天  整理需要学习的相关知识，学习图论和图的数据结构等，以及怎么用Java实现。
 *  2. 第二天  整理需要用到的相关算法，学习戴克斯特拉算法、弗洛伊德算法的思想，学习深广度优先搜索，用Java实现二叉树的深广度优先搜索等。
 *  3. 第三天  编码解题
 *
 * 总结： 很遗憾question7和question10没有解出来。是我对算法了解的还不够深刻。
 *       我从月头学习的算法，接到面试邀约的时候数据结构还没有系统的学到树。
 *       但在三天内能学到这些知识，不管结果怎样，都非常感谢TW。感谢给我一个非常明确且具体的目标，谢谢你。
 */
public class Main {
    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        Vertex A = new Vertex('A');
        Vertex B = new Vertex('B');
        Vertex C = new Vertex('C');
        Vertex D = new Vertex('D');
        Vertex E = new Vertex('E');
        Edge AB5 = new Edge(A, B, 5);
        Edge BC4 = new Edge(B, C, 4);
        Edge CD8 = new Edge(C, D, 8);
        Edge DC8 = new Edge(D, C, 8);
        Edge DE6 = new Edge(D, E, 6);
        Edge AD5 = new Edge(A, D, 5);
        Edge CE2 = new Edge(C, E, 2);
        Edge EB3 = new Edge(E, B, 3);
        Edge AE7 = new Edge(A, E, 7);
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

        Test test = new Test();

        List<Edge> edges1 = new ArrayList<>();
        edges1.add(new Edge(A, B));
        edges1.add(new Edge(B, C));

//        System.out.println(test.question1_5(edges1));

//        System.out.println(test.question6(C,C,weightDirectedGraphByList));

//        System.out.println(test.question7(A,C,weightDirectedGraphByList));

//        System.out.println(test.question8(A,C,weightDirectedGraphByList));

//        System.out.println(test.question9(B,B,weightDirectedGraphByList));
    }
}
