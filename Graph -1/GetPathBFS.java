/*

Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), find and print the path from 
v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
Find the path using BFS and print the shortest path available.
Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
4. Save the input graph in Adjacency Matrix.
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex 
a and b.
The following line contain two integers, that denote the value of v1 and v2.
Output Format :
Print the path from v1 to v2 in reverse order.
Constraints :
2 <= V <= 1000
1 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
0 <= v1 <= 2^31 - 1
0 <= v2 <= 2^31 - 1
Time Limit: 1 second
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
3 0 1
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :

*/

import java.util.*;

public class GetPathBFS {

    private static void getPathBFS(int[][] adj_matrix, int curr_vertex, int v2){
        boolean visited[] = new boolean[adj_matrix.length];
        // hashmap to store parent of each vertex
        HashMap<Integer, Integer> child_parent = new HashMap<>();
        Queue<Integer> pending = new LinkedList<>();

        child_parent.put(curr_vertex, -1);
        pending.add(curr_vertex);
        visited[curr_vertex] = true;

        while(!pending.isEmpty()){
            int temp = pending.poll();
            
            // if v2 found then trace back to the parent node using hashmap
            if(temp == v2){
                System.out.print(temp + " ");
                int parent = child_parent.get(temp);
                while(parent != -1){
                    System.out.print(parent + " ");
                    parent = child_parent.get(parent);
                }
                return;
            }

            for(int i=0; i<adj_matrix.length; i++){
                if(adj_matrix[temp][i] == 1 && !visited[i]){
                    pending.add(i);
                    child_parent.put(i, temp);
                    visited[i] = true;
                }
            }
        }
    }
}
