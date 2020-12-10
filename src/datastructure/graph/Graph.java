package datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author weimin
 * @Date 2020/10/20 0020 17:28
 */
public class Graph {

    // 顶点
    private List<String> nodes;

    // 邻接矩阵
    private int[][] edges;

    // 边的数目
    private int edgeCount;

    private boolean[] isVisited;

    /**
     *
     * @param n 顶点的个数
     */
    public Graph(int n) {
        edges = new int[n][n];
        nodes = new ArrayList<>(n);
        isVisited = new boolean[n];
    }

    // 添加顶点
    public void addNode(String s){
        nodes.add(s);
    }


    // 添加边
    public void addEdge(int v1,int v2,int value){
        edges[v1][v2] = value;
        edges[v2][v1] = value;
        edgeCount++;
    }

    // 节点的个数
    public int getNodeCount(){
        return nodes.size();
    }

    // 边的数量
    public int getEdgeCount(){
        return edgeCount;
    }

    // 节点对应的数据 0->A
    public String get(int i){
        return nodes.get(i);
    }
    // 两个顶点的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    public void show(){
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    // 返回第一个相邻节点的下标
    public int getFirstNextIndex(int i){
        for (int j = 0; j < nodes.size(); j++) {
            if (edges[i][j]==1){
                return j;
            }
        }
        return -1;
    }

    public int getNextNextIndex(int v1,int v2){
        for (int i = v2+1; i < nodes.size(); i++) {
            if (edges[v1][i]==1){
                return i;
            }
        }
        return -1;
    }


    // 深度优先遍历
    private void dfs(int first){
        System.out.println(get(first));
        isVisited[first] = true;

        int i = getFirstNextIndex(first);
        while (i!=-1){
            if(!isVisited[i]){
                System.out.println(get(i));
                isVisited[i] = true;
            }
            i = getNextNextIndex(first,i);
        }
    }
    public void dfs(){
        for (int i = 0; i < getNodeCount(); i++) {
            if(!isVisited[i]){
                dfs(i);
            }
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        graph.addEdge(0,1,1);
        graph.addEdge(0,2,1);
        graph.addEdge(1,2,1);
        graph.addEdge(1,3,1);
        graph.addEdge(1,4,1);

        graph.show();

        graph.dfs();
    }
}
