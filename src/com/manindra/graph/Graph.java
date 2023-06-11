package com.manindra.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private LinkedList<Integer> [] adj;
    private int V; // number of vertices
    private int E; // number of edges

    public Graph(int nodes){
        this.V=nodes;
        this.E=0;
        this.adj=new LinkedList[nodes];

        for (int v=0;v<V;v++){
            adj[v]=new LinkedList<>();
        }
    }

    public void addEdge(int u,int v){
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(V +" vertices " + E+" edges"+"\n");
        for (int v=0;v<V;v++){
            sb.append(v+" : ");
            for (int w:adj[v]){
                sb.append(w+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

       /* Graph g=new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);*/
        Graph g=new Graph(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);
        g.addEdge(2,4);
        System.out.println(g);
        g.BreadthFirstSearch(0);
        System.out.println();
        System.out.println("========");
        g.DepthFirstSearch(0);
        System.out.println();
        g.DepthFirstSearchRecursive();
    }

    public void BreadthFirstSearch(int s){ //iterative
        boolean [] visited=new boolean[V];
        Queue<Integer> queue=new LinkedList<>();
        visited[s]=true;
        queue.offer(s);
        while (!queue.isEmpty()){
            int u=queue.poll();
            System.out.print(u+" ");
            for (int v:adj[u]){
                if (!visited[v]){
                    visited[v]=true;
                    queue.offer(v);
                }
            }
        }
    }
    public void DepthFirstSearch(int s){ //iterative
        boolean [] visited=new boolean[V];
        Stack<Integer> stack=new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()){
            int u=stack.pop();
            if (!visited[u]){
                visited[u]=true;
                System.out.print(u+" ");
                for (int v :adj[u]){
                    if (!visited[v])
                        stack.push(v);
                }
            }
        }
    }
    public void DepthFirstSearchRecursive(){ //recursive //check this method
        boolean [] visited=new boolean[V];
        for (int v=0;v<V;v++){
            if (!visited[v])
                dfs(v,visited);
        }
    }
    public void dfs(int v ,boolean[] visited){
        visited[v]=true;
        System.out.print(v+ " ");
        for (int w :adj[v]){
            if (!visited[w])
                dfs(w,visited);
        }
    }
}
