import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  private final Map<Integer, List<Integer>> graph;

  public Main() {
    graph = new HashMap<>();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    StringTokenizer st = new StringTokenizer(scanner.nextLine());
    int vertex = Integer.parseInt(st.nextToken());
    int edge = Integer.parseInt(st.nextToken());
    int start = Integer.parseInt(st.nextToken());

    Main graph = new Main();
    for (int i = 0; i < edge; i++) {
      StringTokenizer st2 = new StringTokenizer(scanner.nextLine());
      graph.addEdge(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken()));
    }

    for (Entry entry : graph.graph.entrySet()) {
      Collections.sort((List<Integer>) entry.getValue());
    }
    graph.dfs(start);
    System.out.println();
    graph.bfs(start);
  }

  public void addEdge(int source, int destination) {
    graph.putIfAbsent(source, new ArrayList<>());
    graph.putIfAbsent(destination, new ArrayList<>());
    graph.get(source).add(destination);
    graph.get(destination).add(source); // 양방향 그래프
  }

  public void dfs(int start) {
    Set<Integer> visited = new HashSet<>();
    dfsUtil(start, visited);
  }

  public void dfsUtil(int vertex, Set<Integer> visited) {
    visited.add(vertex);
    System.out.print(vertex + " ");

    for (int neighbor : graph.getOrDefault(vertex, new ArrayList<>())) {
      if (!visited.contains(neighbor)) {
        dfsUtil(neighbor, visited);
      }
    }
  }

  public void bfs(int start) {
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();

    visited.add(start);
    queue.offer(start);

    while (!queue.isEmpty()) {
      int current = queue.poll();
      System.out.print(current + " ");

      for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
        if (!visited.contains(neighbor)) {
          visited.add(neighbor);
          queue.offer(neighbor);
        }
      }
    }
  }
}