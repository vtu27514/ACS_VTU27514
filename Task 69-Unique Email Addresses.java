import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Set<String> unique = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String email = sc.next();

            String[] parts = email.split("@", 2);
            String local = parts[0];
            String domain = parts[1];

            int plus = local.indexOf('+');

            if (plus != -1) {
                local = local.substring(0, plus);
            }

            local = local.replace(".", "");

            unique.add(local + "@" + domain);
        }

        System.out.println(unique.size());
    }
}
