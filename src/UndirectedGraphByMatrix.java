/**
 * @Author: 张健
 * @CreateDate: 2019-03-15 11:15
 * @Version: 1.0
 * @Description: 矩阵实现无向图
 */
public class UndirectedGraphByMatrix {

    // 图顶点个数
    private int size;

    // 所有顶点
    private char[] vertexs;

    // 各顶点之间/边的关系
    private int[][] matrix;

    public UndirectedGraphByMatrix(char[] vertexs, char[][] edges) {
        this.size = vertexs.length;
        this.vertexs = vertexs;
        // 初始化矩阵大小
        this.matrix = new int[size][size];
        for (char[] c : edges) {
            // 根据char获取对应的位置
            int p0 = getPosition(c[0]);
            int p1 = getPosition(c[1]);

            // 无向图左顶点到右低点对称
            matrix[p0][p1] = 1;
            matrix[p1][p0] = 1;
        }
    }

    /**
     * 通过char定位vertexs中index
     */
    private int getPosition(char c) {
        for (int i = 0; i < size; i++) {
            if (c == vertexs[i]){
                return i;
            }
        }
        return -1;
    }

    public void print(){
        for (int[] ints :matrix) {
            for (int i : ints) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G','H','I','J','K'};
        char[][] edges = new char[][]{
                {'A', 'C'},
                {'A', 'D'},
                {'A', 'F'},
                {'B', 'C'},
                {'C', 'D'},
                {'E', 'G'},
                {'D', 'G'},
                {'I','J'},
                {'J','G'},};
        UndirectedGraphByMatrix undirectedGraphByMatrix = new UndirectedGraphByMatrix(vexs, edges);
        undirectedGraphByMatrix.print();
    }
}
