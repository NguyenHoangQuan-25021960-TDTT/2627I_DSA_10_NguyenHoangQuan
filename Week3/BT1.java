import java.util.*;

public class BT1 {
  public static String isBalanced(String s) {
    Deque<Character> stack = new ArrayDeque<>();

    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) return "NO";
        char top = stack.pop();
        if ((c == ')' && top != '(') ||
                (c == '}' && top != '{') ||
                (c == ']' && top != '[')) {
          return "NO";
        }
      }
    }

    return stack.isEmpty() ? "YES" : "NO";
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    if (scanner.hasNextInt()) {
      int n = scanner.nextInt();
      while (n-- > 0) {
        String s = scanner.next();
        System.out.println(isBalanced(s));
      }
    }
    scanner.close();
  }
}

