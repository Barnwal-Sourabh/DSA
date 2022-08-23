package Graphs;

import java.util.*;

class Edge implements Comparable<Edge> {
	int source;
	int dest;
	int weight;

	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}

public class KrushKalAlgorithm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();

		Edge input[] = new Edge[n - 1];
		for (int i = 0; i < e; i++) {
			input[i] = new Edge();
			input[i].source = sc.nextInt();
			input[i].dest = sc.nextInt();
			input[i].weight = sc.nextInt();
		}
		
		krushKal(input, n);
		sc.close();
	}

	private static void krushKal(Edge[] input, int n) {
		//Arrays.sort(input);
		Edge output[] = new Edge[n - 1];

		int parent[] = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		int count = 0;
		int i = 0;

		while (count < n - 1) {
			Edge currentEdge = input[i];
			int sourceParent = findParent(currentEdge.source, parent);
			int destParent = findParent(currentEdge.dest, parent);

			if (sourceParent != destParent) {
				output[count] = currentEdge;
				count++;
				parent[sourceParent] = destParent;
			}
			i++;
		}

		for (Edge edge : output) {
			if (edge.source < edge.dest) {
				System.out.println(edge.source + " " + edge.dest + " " + edge.weight);
			} else {
				System.out.println(edge.dest + " " + edge.source + " " + edge.weight);
			}
		}
	}

	private static int findParent(int v, int[] parent) {
		if (parent[v] == v) {
			return v;
		}
		return findParent(parent[v], parent);
	}
}