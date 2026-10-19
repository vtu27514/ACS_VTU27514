import java.util.*;

public class Main {
    static String longestNice(String s) {
        if (s.length() < 2) {
            return "";
        }

        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            set.add(c);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!set.contains(Character.toLowerCase(c)) ||
                !set.contains(Character.toUpperCase(c))) {
                String left = longestNice(s.substring(0, i));
                String right = longestNice(s.substring(i + 1));

                return left.length() >= right.length() ? left : right;
            }
        }

        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(longestNice(s));
    }
}
