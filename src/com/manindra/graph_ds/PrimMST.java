package com.manindra.graph_ds;

import java.util.*;

class PrimMST {
    static class Edge {
        int vertex, weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        List<List<Edge>> graph = new ArrayList<>();

        // Initialize adjacency list for graph
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph
        addEdge(graph, 0, 1, 1); // A-B
        addEdge(graph, 1, 2, 3); // B-C
        addEdge(graph, 2, 3, 4); // C-D
        addEdge(graph, 3, 4, 2); // D-E
        addEdge(graph, 4, 0, 5); // E-A
        addEdge(graph, 1, 3, 2); // B-D

        primMST(graph, vertices);
    }

    static void addEdge(List<List<Edge>> graph, int src, int dest, int weight) {
        graph.get(src).add(new Edge(dest, weight));
        graph.get(dest).add(new Edge(src, weight));
    }

    static void primMST(List<List<Edge>> graph, int vertices) {
        boolean[] inMST = new boolean[vertices];
        int[] key = new int[vertices];
        int[] parent = new int[vertices];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        // Start from vertex 0
        key[0] = 0;
        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            inMST[u] = true;

            for (Edge neighbor : graph.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    pq.add(new Edge(v, key[v]));
                }
            }
        }

        // Print MST
        System.out.println("Edges in the Minimum Spanning Tree:");
        int totalWeight = 0;
        for (int i = 1; i < vertices; i++) {
            System.out.println("Edge: " + parent[i] + " - " + i + " | Weight: " + key[i]);
            totalWeight += key[i];
        }
        System.out.println("Total Weight: " + totalWeight);
    }

    /*
     static final int V=4;
	public static int primMST(int graph[][])
    {

    	int[] key=new int[V];int res=0;
    	Arrays.fill(key,Integer.MAX_VALUE);
    	boolean[] mSet=new boolean[V]; key[0]=0;

    	for (int count = 0; count < V ; count++)
    	{
    		int u = -1;

    		for(int i=0;i<V;i++)
    		    if(!mSet[i]&&(u==-1||key[i]<key[u]))
    		        u=i;
    		mSet[u] = true;
    		res+=key[u];


    		for (int v = 0; v < V; v++)

    			if (graph[u][v]!=0 && mSet[v] == false)
    				key[v] = Math.min(key[v],graph[u][v]);
    	}
        return res;
    }

	public static void main(String[] args)
	{
		int graph[][] = new int[][] { { 0, 5, 8, 0},
    						{ 5, 0, 10, 15 },
    						{ 8, 10, 0, 20 },
    						{ 0, 15, 20, 0 },};

		System.out.print(primMST(graph));
	}
     */
}

