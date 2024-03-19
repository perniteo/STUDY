import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int answer;
  static boolean[][] graph;
  static boolean[] visited;

  static void addEdge(int source, int destination) {
    graph[source][destination] = graph[destination][source] = true;
  }

  static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    visited[start] = true;

    queue.offer(start);

    while (!queue.isEmpty()) {
      int now = queue.poll();

      for (int i = 1; i < graph.length; i++) {
        if (graph[now][i] && !visited[i]) {
          queue.offer(i);
          visited[i] = true;
          ++answer;
        }
      }
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vertex = Integer.parseInt(br.readLine());
    graph = new boolean[vertex + 1][vertex + 1];
    visited = new boolean[vertex + 1];

    int edge = Integer.parseInt(br.readLine());

    for (int i = 0; i < edge; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int s = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      addEdge(s, d);
    }
    answer = 0;

    bfs(1);

    System.out.println(answer);

  }
}