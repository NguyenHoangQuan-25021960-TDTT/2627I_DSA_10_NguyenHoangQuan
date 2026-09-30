import java.io.*;
import java.util.*;

public class BT4 {

  public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    int sum1 = 0, sum2 = 0, sum3 = 0;

    for (int h : h1) sum1 += h;
    for (int h : h2) sum2 += h;
    for (int h : h3) sum3 += h;
    int i = 0, j = 0, k = 0;
    while (sum1 != sum2 || sum2 != sum3) {
      if (sum1 >= sum2 && sum1 >= sum3) {
        sum1 -= h1.get(i++);
      } else if (sum2 >= sum1 && sum2 >= sum3) {
        sum2 -= h2.get(j++);
      } else {
        sum3 -= h3.get(k++);
      }
    }

    return sum1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String line = br.readLine();
    if (line == null) return;

    String[] n1n2n3 = line.trim().split("\\s+");
    int n1 = Integer.parseInt(n1n2n3[0]);
    int n2 = Integer.parseInt(n1n2n3[1]);
    int n3 = Integer.parseInt(n1n2n3[2]);

    List<Integer> h1 = readList(br, n1);
    List<Integer> h2 = readList(br, n2);
    List<Integer> h3 = readList(br, n3);

    System.out.println(equalStacks(h1, h2, h3));
  }

  private static List<Integer> readList(BufferedReader br, int size) throws IOException {
    List<Integer> list = new ArrayList<>(size);
    if (size == 0) return list;

    String[] parts = br.readLine().trim().split("\\s+");
    for (String part : parts) {
      if (!part.isEmpty()) {
        list.add(Integer.parseInt(part));
      }
    }
    return list;
  }
}