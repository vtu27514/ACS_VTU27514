import java.util.*;

public class Main {
    static List<Integer> topo(
            List<List<Integer>> graph, int[] indegree) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        List<Integer> order = new ArrayList<>();

        while (!q.isEmpty()) {
            int u = q.poll();
            order.add(u);

            for (int v : graph.get(u)) {
                if (--indegree[v] == 0) q.offer(v);
            }
        }

        return order.size() == indegree.length ? order : new ArrayList<>();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int groupCount = sc.nextInt();

        int[] group = new int[n];

        for (int i = 0; i < n; i++) {
            group[i] = sc.nextInt();
            if (group[i] == -1) group[i] = groupCount++;
        }

        List<List<Integer>> itemGraph = new ArrayList<>();
        List<List<Integer>> groupGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) itemGraph.add(new ArrayList<>());
        for (int i = 0; i < groupCount; i++) groupGraph.add(new ArrayList<>());

        int[] itemDegree = new int[n];
        int[] groupDegree = new int[groupCount];

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();

            for (int j = 0; j < k; j++) {
                int before = sc.nextInt();

                itemGraph.get(before).add(i);
                itemDegree[i]++;

                if (group[before] != group[i]) {
                    groupGraph.get(group[before]).add(group[i]);
                    groupDegree[group[i]]++;
                }
            }
        }

        List<Integer> itemOrder = topo(itemGraph, itemDegree);
        List<Integer> groupOrder = topo(groupGraph, groupDegree);

        if (itemOrder.isEmpty() || groupOrder.isEmpty()) {
            System.out.println("[]");
            return;
        }

        Map<Integer, List<Integer>> grouped = new HashMap<>();

        for (int g = 0; g < groupCount; g++) {
            grouped.put(g, new ArrayList<>());
        }

        for (int item : itemOrder) {
            grouped.get(group[item]).add(item);
        }

        List<Integer> result = new ArrayList<>();

        for (int g : groupOrder) {
            result.addAll(grouped.get(g));
        }

        System.out.println(result);
    }
}
