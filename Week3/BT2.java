import java.io.*;
import java.util.*;

public class BT2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Deque<Integer> stackEnqueue = new ArrayDeque<>();
    Deque<Integer> stackDequeue = new ArrayDeque<>();

    if (scanner.hasNextInt()) {
      int q = scanner.nextInt();

      while (q-- > 0) {
        int type = scanner.nextInt();

        if (type == 1) {
          int x = scanner.nextInt();
          stackEnqueue.push(x);
        } else if (type == 2) {
          shiftStacks(stackEnqueue, stackDequeue);
          if (!stackDequeue.isEmpty()) {
            stackDequeue.pop();
          }
        } else if (type == 3) {
          shiftStacks(stackEnqueue, stackDequeue);
          if (!stackDequeue.isEmpty()) {
            System.out.println(stackDequeue.peek());
          }
        }
      }
    }

    scanner.close();
  }

  private static void shiftStacks(Deque<Integer> stackEnqueue, Deque<Integer> stackDequeue) {
    if (stackDequeue.isEmpty()) {
      while (!stackEnqueue.isEmpty()) {
        stackDequeue.push(stackEnqueue.pop());
      }
    }
  }
}
