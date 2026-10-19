import java.util.*;

public class Main {
    static Map<String, String> parent = new HashMap<>();

    static String find(String x) {
        if (!parent.get(x).equals(x)) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    static void union(String a, String b) {
        String rootA = find(a);
        String rootB = find(b);

        if (!rootA.equals(rootB)) {
            parent.put(rootA, rootB);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<List<String>> accounts = new ArrayList<>();
        Map<String, String> emailName = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int k = sc.nextInt();

            List<String> emails = new ArrayList<>();

            for (int j = 0; j < k; j++) {
                String email = sc.next();
                emails.add(email);

                parent.putIfAbsent(email, email);
                emailName.put(email, name);
            }

            accounts.add(emails);

            for (int j = 1; j < emails.size(); j++) {
                union(emails.get(0), emails.get(j));
            }
        }

        Map<String, TreeSet<String>> merged = new TreeMap<>();

        for (String email : parent.keySet()) {
            String root = find(email);
            merged.putIfAbsent(root, new TreeSet<>());
            merged.get(root).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (TreeSet<String> emails : merged.values()) {
            List<String> account = new ArrayList<>();
            account.add(emailName.get(emails.first()));
            account.addAll(emails);
            result.add(account);
        }

        result.sort(Comparator.comparing(a -> a.get(0)));

        for (List<String> account : result) {
            System.out.println(account);
        }
    }
}
