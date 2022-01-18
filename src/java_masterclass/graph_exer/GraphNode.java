package java_masterclass.graph_exer;
import java.util.*;

/**
 * @author huimin
 * @create 2022-01-11 22:37
 */


public  class GraphNode {
    public String name;
    public int index;
    public boolean isVisited = false;
    public GraphNode parent;
    public Graph_Route_btw_nodes.State state;

    public ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}