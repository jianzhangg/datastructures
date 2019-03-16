/**
 * @author: jian.zhangg
 * @date: 19-3-15 下午9:03
 * @version: V1.0
 * @Description: 带权重有向图通过领接表实现
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WeightedDirectedGraphByList {

    private List<Vertex> vertexList;   //图的顶点集
    private Map<Vertex, List<Edge>> ver_edgeList_map;  //图的每个顶点对应的有向边

    public WeightedDirectedGraphByList(List<Vertex> vertexList, Map<Vertex, List<Edge>> ver_edgeList_map) {
        super();
        this.vertexList = vertexList;
        this.ver_edgeList_map = ver_edgeList_map;
    }

    public List<Vertex> getVertexList() {
        return vertexList;
    }

    public void setVertexList(List<Vertex> vertexList) {
        this.vertexList = vertexList;
    }


    public Map<Vertex, List<Edge>> getVer_edgeList_map() {
        return ver_edgeList_map;
    }

    public void setVer_edgeList_map(Map<Vertex, List<Edge>> ver_edgeList_map) {
        this.ver_edgeList_map = ver_edgeList_map;
    }


    static class Edge {
        private Vertex startVertex;  //此有向边的起始点
        private Vertex endVertex;  //此有向边的终点
        private int weight;  //此有向边的权值

        public Edge(Vertex startVertex, Vertex endVertex, int weight) {
            super();
            this.startVertex = startVertex;
            this.endVertex = endVertex;
            this.weight = weight;
        }

        public Edge() {
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

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    static class Vertex {
        private final static int infinite_dis = Integer.MAX_VALUE;

        private String name;  //节点名字
        private boolean known; //此节点之前是否已知
        private int adjuDist; //此节点距离
        private Vertex parent; //当前从初始节点到此节点的最短路径下，的父节点。

        public Vertex() {
            this.known = false;
            this.adjuDist = infinite_dis;
            this.parent = null;
        }

        public Vertex(String name) {
            this.known = false;
            this.adjuDist = infinite_dis;
            this.parent = null;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isKnown() {
            return known;
        }

        public void setKnown(boolean known) {
            this.known = known;
        }

        public int getAdjuDist() {
            return adjuDist;
        }

        public void setAdjuDist(int adjuDist) {
            this.adjuDist = adjuDist;
        }

        public Vertex getParent() {
            return parent;
        }

        public void setParent(Vertex parent) {
            this.parent = parent;
        }

        /**
         * 重新Object父类的equals方法
         */
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Vertex)) {
                throw new ClassCastException("an object to compare with a Vertex must be Vertex");
            }

            if (this.name == null) {
                throw new NullPointerException("name of Vertex to be compared cannot be null");
            }

            return this.name.equals(obj);
        }
    }

    public void setRoot(Vertex v) {
        v.setParent(null);
        v.setAdjuDist(0);
    }


    /**
     * @param startIndex dijkstra遍历的起点节点下标
     * @param destIndex  dijkstra遍历的终点节点下标
     */
    public void dijkstraTravasal(int startIndex, int destIndex) {
        Vertex start = vertexList.get(startIndex);
        Vertex dest = vertexList.get(destIndex);
        String path = "[" + dest.getName() + "]";

        setRoot(start);
        updateChildren(vertexList.get(startIndex));

        int shortest_length = dest.getAdjuDist();

        while ((dest.getParent() != null) && (!dest.equals(start))) {
            path = "[" + dest.getParent().getName() + "] --> " + path;
            dest = dest.getParent();
        }

        System.out.println("[" + vertexList.get(startIndex).getName() + "] to [" +
                vertexList.get(destIndex).getName() + "] dijkstra shortest path :: " + path);
        System.out.println("shortest length::" + shortest_length);
    }

    /**
     * 从初始节点开始递归更新邻接表
     *
     * @param v
     */
    private void updateChildren(Vertex v) {
        if (v == null) {
            return;
        }

        if (ver_edgeList_map.get(v) == null || ver_edgeList_map.get(v).size() == 0) {
            return;
        }

        List<Vertex> childrenList = new LinkedList<WeightedDirectedGraphByList.Vertex>();
        for (Edge e : ver_edgeList_map.get(v)) {
            Vertex childVertex = e.getEndVertex();

            //如果子节点之前未知，则把当前子节点加入更新列表
            if (!childVertex.isKnown()) {
                childVertex.setKnown(true);
                childVertex.setAdjuDist(v.getAdjuDist() + e.getWeight());
                childVertex.setParent(v);
                childrenList.add(childVertex);
            }

            //子节点之前已知，则比较子节点的adjustDist&&knowDist
            int nowDist = v.getAdjuDist() + e.getWeight();
            if (nowDist < childVertex.getAdjuDist()) {
                childVertex.setAdjuDist(nowDist);
                childVertex.setParent(v);
            }
        }

        //更新每一个子节点
        for (Vertex vc : childrenList) {
            updateChildren(vc);
        }
    }

    public static void main(String[] args) {
        Vertex v1= new Vertex("v1");
        Vertex v2= new Vertex("v2");
        Vertex v3= new Vertex("v3");
        Vertex v4= new Vertex("v4");
        Vertex v5= new Vertex("v5");
        Vertex v6= new Vertex("v6");
        Vertex v7= new Vertex("v7");
        Vertex v8= new Vertex("v8");

        List<Vertex> verList = new LinkedList<WeightedDirectedGraphByList.Vertex>();
        verList.add(v1);
        verList.add(v2);
        verList.add(v3);
        verList.add(v4);
        verList.add(v5);
        verList.add(v6);
        verList.add(v7);
        verList.add(v8);

        Map<Vertex, List<Edge>> vertex_edgeList_map = new HashMap<WeightedDirectedGraphByList.Vertex, List<Edge>>();

        List<Edge> v1List = new LinkedList<WeightedDirectedGraphByList.Edge>();
        v1List.add(new Edge(v1,v2,6));
        v1List.add(new Edge(v1,v4,1));
        v1List.add(new Edge(v1,v4,1));

        List<Edge> v2List = new LinkedList<WeightedDirectedGraphByList.Edge>();
        v2List.add(new Edge(v2,v3,43));
        v2List.add(new Edge(v2,v4,11));
        v2List.add(new Edge(v2,v5,6));

        List<Edge> v3List = new LinkedList<WeightedDirectedGraphByList.Edge>();
        v3List.add(new Edge(v3,v8,8));

        List<Edge> v4List = new LinkedList<WeightedDirectedGraphByList.Edge>();
        v4List.add(new Edge(v4,v3,15));
        v4List.add(new Edge(v4,v5,12));

        List<Edge> v5List = new LinkedList<WeightedDirectedGraphByList.Edge>();
        v5List.add(new Edge(v5,v3,38));
        v5List.add(new Edge(v5,v8,13));
        v5List.add(new Edge(v5,v7,24));

        List<Edge> v6List = new LinkedList<WeightedDirectedGraphByList.Edge>();
        v6List.add(new Edge(v6,v5,1));
        v6List.add(new Edge(v6,v7,12));

        List<Edge> v7List = new LinkedList<WeightedDirectedGraphByList.Edge>();
        v7List.add(new Edge(v7,v8,20));

        vertex_edgeList_map.put(v1, v1List);
        vertex_edgeList_map.put(v2, v2List);
        vertex_edgeList_map.put(v3, v3List);
        vertex_edgeList_map.put(v4, v4List);
        vertex_edgeList_map.put(v5, v5List);
        vertex_edgeList_map.put(v6, v6List);
        vertex_edgeList_map.put(v7, v7List);


        WeightedDirectedGraphByList g = new WeightedDirectedGraphByList(verList, vertex_edgeList_map);
//		g.dijkstraTravasal(1, 5);
        g.dijkstraTravasal(0, 7);
    }
}

