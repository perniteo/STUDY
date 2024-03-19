import java.util.*;

public class Main {

  static int[][] graph;
  static boolean[] visited;

  static void addEdge(int source, int destination) {
    graph[source][destination] = 1;
    graph[destination][source] = 1;
  }

  static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    visited[start] = true;

    queue.offer(start);

    while (!queue.isEmpty()) {
      int now = queue.poll();

      for (int i = 1; i < graph.length; i++) {
        if (graph[now][i] == 1 && !visited[i]) {
          queue.offer(i);
          visited[i] = true;
        }
      }
    }

  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int vertex = scanner.nextInt();
    graph = new int[vertex + 1][vertex + 1];
    visited = new boolean[vertex + 1];

    int edge = scanner.nextInt();

    for (int i = 0; i < edge; i++) {
      int s = Integer.parseInt(scanner.next());
      int d = Integer.parseInt(scanner.next());
      addEdge(s, d);
    }
    bfs(1);

    int answer = -1;
    for (boolean b : visited) {
      if (b) {
        ++answer;
      }
    }
    System.out.println(answer);
  }

}