package day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Runner {

  private static int     _key   = 5;
  private static int[][] keypad = new int[][] { { 1 }, { 2, 3, 4 }, { 5, 6, 7, 8, 9 }, { 10, 11, 12 }, { 13 } };

  public static void main(String[] args) {
    for (int i = 0; i < keypad.length; i++) {
      for (int j = 0; j < keypad[0].length; j++) {
        System.out.println("key: " + keypad[i][j] + " " + mapKeyToIndices(keypad[i][j])[0] + " " + mapKeyToIndices(keypad[i][j])[1]);
      }
    }
    try {
      BufferedReader reader = new BufferedReader(new FileReader("input/day2input1.txt"));
      // BufferedReader reader = new BufferedReader(new
      // FileReader("input/test.txt"));
      while (reader.ready()) {
        String line = reader.readLine();
        System.out.print(computeKey(line));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static int computeKey(String line) {
    char direction;
    for (int i = 0; i < line.length(); i++) {
      direction = line.charAt(i);
      if (direction == 'U') {
        int[] indices = mapKeyToIndices(_key - 3);
        _key = keypad[indices[0]][indices[1]];
      } else if (direction == 'D') {
        int[] indices = mapKeyToIndices(_key + 3);
        _key = keypad[indices[0]][indices[1]];
      } else if (direction == 'L') {
        // out of bounds check
        if (_key % 3 == 1) {
          continue;
        }
        int[] indices = mapKeyToIndices(_key - 1);
        _key = keypad[indices[0]][indices[1]];
      } else if (direction == 'R') {
        // out of bounds check
        if (_key % 3 == 0) {
          continue;
        }
        int[] indices = mapKeyToIndices(_key + 1);
        _key = keypad[indices[0]][indices[1]];
      } else {
        System.out.println(direction);
      }
    }
    return _key;
  }

  private static int[] mapKeyToIndices(int key) {
    if (key == 1) {
      return new int[] { 0, 0 };
    }
    if (key == 2) {
      return new int[] { 1, 0 };
    }
    if (key == 3) {
      return new int[] { 1, 1 };
    }
    if (key == 4) {
      return new int[] { 1, 2 };
    }
    if (key == 5) {
      return new int[] { 2, 0 };
    }
    if (key == 6) {
      return new int[] { 2, 1 };
    }
    if (key == 7) {
      return new int[] { 2, 2 };
    }
    if (key == 8) {
      return new int[] { 2, 3 };
    }
    if (key == 9) {
      return new int[] { 2, 4 };
    }
    if (key == 10) {
      return new int[] { 3, 0 };
    }
    if (key == 11) {
      return new int[] { 3, 1 };
    }
    if (key == 12) {
      return new int[] { 3, 2 };
    }
    if (key == 13) {
      return new int[] { 4, 0 };
    }
    return mapKeyToIndices(_key);

  }
}
