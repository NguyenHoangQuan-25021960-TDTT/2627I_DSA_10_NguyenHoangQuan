import java.io.*;
import java.util.*;

public class BT3 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int q = Integer.parseInt(br.readLine().trim());

    StringBuilder s = new StringBuilder();
    Deque<String> history = new ArrayDeque<>();

    while (q-- > 0) {
      String line = br.readLine();
      if (line == null || line.isEmpty()) continue;

      String[] parts = line.split(" ");
      int type = Integer.parseInt(parts[0]);

      switch (type) {
        case 1:
          history.push(s.toString());
          s.append(parts[1]);
          break;

        case 2:
          history.push(s.toString());
          int k = Integer.parseInt(parts[1]);
          s.delete(s.length() - k, s.length());
          break;

        case 3:
          int idx = Integer.parseInt(parts[1]) - 1;
          System.out.println(s.charAt(idx));
          break;

        case 4:
          if (!history.isEmpty()) {
            s = new StringBuilder(history.pop());
          }
          break;
      }
    }
  }
}
