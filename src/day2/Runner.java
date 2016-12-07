package day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Runner {

  private static int     _key   = 5;
  private static int[][] keypad = new int[][] { { 1 }, { 2, 3, 4 }, { 5, 6, 7, 8, 9 },
      { 10, 11, 12 }, { 13 } };

  public static void main(String[] args) {
    // for (int i = 0; i < keypad.length; i++) {
    // for (int j = 0; j < keypad[0].length; j++) {
    // System.out.println("key: " + keypad[i][j] + " " +
    // mapKeyToIndices(keypad[i][j])[0]
    // + " " + mapKeyToIndices(keypad[i][j])[1]);
    // }
    // }
    try {
      BufferedReader reader = new BufferedReader(new FileReader("input/day2input1.txt"));
      // BufferedReader reader = new BufferedReader(new
      // FileReader("input/test.txt"));
      while (reader.ready()) {
        String line = reader.readLine();
        System.out.println(computeKey(line));
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
        if (_key == 1) {
          continue;
        } else if (_key == 2) {
          continue;
        }  else if (_key == 3) {
          _key = 1;
        } else if (_key == 4) {
          continue;
        } else if (_key == 5) {
          continue;
        } else if (_key == 6) {
          _key = 2;
        } else if (_key == 7) {
          _key = 3;
        } else if (_key == 8) {
          _key = 4;
        } else if (_key == 9) {
          continue;
        } else if (_key == 10) {
          _key = 6;
        } else if (_key == 11) {
          _key = 7;
        } else if (_key == 12) {
          _key = 8;
        } else if (_key == 13) {
          _key = 11;
        }
      } else if (direction == 'D') {
        if (_key == 1) {
          _key = 3;
        } else if (_key == 2) {
          _key = 6;
        } else if (_key == 3) {
          _key = 7;
        } else if (_key == 4) {
          _key = 8;
        } else if (_key == 5) {
          continue;
        } else if (_key == 6) {
          _key = 10;
        } else if (_key == 7) {
          _key = 11;
        } else if (_key == 8) {
          _key = 12;
        } else if (_key == 9) {
          continue;
        } else if (_key == 10) {
          continue;
        } else if (_key == 11) {
          _key = 13;
        } else if (_key == 12) {
          continue;
        } else if (_key == 13) {
          continue;
        }
      } else if (direction == 'L') {
        if (_key == 1) {
          continue;
        } else if (_key == 2) {
          continue;
        } else if (_key == 3) {
          _key = 2;
        } else if (_key == 4) {
          _key = 3;
        } else if (_key == 5) {
          continue;
        } else if (_key == 6) {
          _key = 5;
        } else if (_key == 7) {
          _key = 6;
        } else if (_key == 8) {
          _key = 7;
        } else if (_key == 9) {
          _key = 8;
        } else if (_key == 10) {
          continue;
        } else if (_key == 11) {
          _key = 10;
        } else if (_key == 12) {
          _key = 11;
        } else if (_key == 13) {
          continue;
        }
      } else if (direction == 'R') {
        if (_key == 1) {
          continue;
        } else if (_key == 2) {
          _key = 3;
        } else if (_key == 3) {
          _key = 4;
        } else if (_key == 4) {
          continue;
        } else if (_key == 5) {
          _key = 6;
        } else if (_key == 6) {
          _key = 7;
        } else if (_key == 7) {
          _key = 8;
        } else if (_key == 8) {
          _key = 9;
        } else if (_key == 9) {
          continue;
        } else if (_key == 10) {
          _key = 11;
        } else if (_key == 11) {
          _key = 12;
        } else if (_key == 12) {
          continue;
        } else if (_key == 13) {
          continue;
        }
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
