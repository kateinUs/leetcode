package java_masterclass.graph_exer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Question:
 *      Given a directed graph and w nodes (S and E); design an algorithm to find
 *      out whether there is a route from S to E
 * @author huimin
 * @create 2022-01-11 22:36
 */

public class Graph_Route_btw_nodes {


    static ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

    public enum State {
        Unvisited, Visited, Visiting;
    }

    public Graph_Route_btw_nodes(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addDirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbors.add(second);
    }

//  Route Between Nodes
    public static boolean search(GraphNode S, GraphNode E){
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(S);
        while (!queue.isEmpty()){
            GraphNode currentNode = queue.remove();
            currentNode.isVisited = true;
            ArrayList<GraphNode> neighbors = currentNode.neighbors;
            for(GraphNode node: neighbors){
                if(node == E)
                    return true;
                if(!node.isVisited){
                    queue.add(node);
                    node.isVisited = true;
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A",0));
        nodeList.add(new GraphNode("B",1));
        nodeList.add(new GraphNode("C",2));
        nodeList.add(new GraphNode("D",3));
        nodeList.add(new GraphNode("E",4));
        nodeList.add(new GraphNode("F",5));
        nodeList.add(new GraphNode("G",6));
        nodeList.add(new GraphNode("H",7));
        nodeList.add(new GraphNode("I",8));
        nodeList.add(new GraphNode("J",9));
        Graph_Route_btw_nodes newGraphRoutebtwnodes = new Graph_Route_btw_nodes(nodeList);
        newGraphRoutebtwnodes.addDirectedEdge(0,1);
        newGraphRoutebtwnodes.addDirectedEdge(0,2);
        newGraphRoutebtwnodes.addDirectedEdge(0,3);
        newGraphRoutebtwnodes.addDirectedEdge(1,9);
        newGraphRoutebtwnodes.addDirectedEdge(2,6);
        newGraphRoutebtwnodes.addDirectedEdge(4,0);
        newGraphRoutebtwnodes.addDirectedEdge(4,5);
        newGraphRoutebtwnodes.addDirectedEdge(5,8);
        newGraphRoutebtwnodes.addDirectedEdge(6,7);
        newGraphRoutebtwnodes.addDirectedEdge(6,3);
        boolean res = newGraphRoutebtwnodes.search(nodeList.get(0), nodeList.get(4));
        boolean res2 = newGraphRoutebtwnodes.search(nodeList.get(4), nodeList.get(0));
        System.out.println(res);
        System.out.println(res2);
    }



}

