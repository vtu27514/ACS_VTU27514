import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<String, List<String>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = sc.next();

            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }

        System.out.println(new ArrayList<>(map.values()));
    }
}
