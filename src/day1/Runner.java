package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
  public static void main(String[] args) {
    ArrayList<Point> locations = new ArrayList<Point>();
    locations.add(new Point(0, 0));
    int[] directions = new int[] { 1, 2, 3, 4 }; // 1 - N 2 - E 3 - S 4 - W
    int currentDirection = 1;
    int x = 0;
    int y = 0;
    try {
      BufferedReader reader = new BufferedReader(new FileReader("input/day1input1.txt"));
      // BufferedReader reader = new BufferedReader(new
      // FileReader("input/test.txt"));
      String line = reader.readLine();
      Scanner s = new Scanner(line);
      s.useDelimiter(",");
      while (s.hasNext()) {
        ArrayList<Point> toAdd = new ArrayList<Point>();
        int newX = 0;
        int newY = 0;
        String token = s.next().trim();
        if (token.charAt(0) == 'L') {
          currentDirection--;
          if (currentDirection == 0) {
            currentDirection = 4;
          }
          if (currentDirection == 1) {
            newY = y + Integer.parseInt(token.substring(1, token.length()));
            for (int i = y + 1; i <= newY; i++) {
              Point newPoint = new Point(x, i);
              checkForIntersection(locations, newPoint);
              toAdd.add(newPoint);
            }
            y += Integer.parseInt(token.substring(1, token.length()));
          }
          if (currentDirection == 2) {
            newX = x + Integer.parseInt(token.substring(1, token.length()));
            for (int i = x + 1; i <= newX; i++) {
              Point newPoint = new Point(i, y);
              checkForIntersection(locations, newPoint);
              toAdd.add(newPoint);
            }
            x += Integer.parseInt(token.substring(1, token.length()));
          }
          if (currentDirection == 3) {
            newY = y - Integer.parseInt(token.substring(1, token.length()));
            for (int i = y - 1; i >= newY; i--) {
              Point newPoint = new Point(x, i);
              checkForIntersection(locations, newPoint);
              toAdd.add(newPoint);
            }
            y -= Integer.parseInt(token.substring(1, token.length()));
          }
          if (currentDirection == 4) {
            newX = x - Integer.parseInt(token.substring(1, token.length()));
            for (int i = x - 1; i >= newX; i--) {
              Point newPoint = new Point(i, y);
              checkForIntersection(locations, newPoint);
              toAdd.add(newPoint);
            }
            x -= Integer.parseInt(token.substring(1, token.length()));
          }
        } else {
          currentDirection++;
          if (currentDirection == 5) {
            currentDirection = 1;
          }
          if (currentDirection == 1) {
            newY = y + Integer.parseInt(token.substring(1, token.length()));
            for (int i = y + 1; i <= newY; i++) {
              Point newPoint = new Point(x, i);
              checkForIntersection(locations, newPoint);
              toAdd.add(newPoint);
            }
            y += Integer.parseInt(token.substring(1, token.length()));
          }
          if (currentDirection == 2) {
            newX = x + Integer.parseInt(token.substring(1, token.length()));
            for (int i = x + 1; i <= newX; i++) {
              Point newPoint = new Point(i, y);
              checkForIntersection(locations, newPoint);
              toAdd.add(newPoint);
            }
            x += Integer.parseInt(token.substring(1, token.length()));
          }
          if (currentDirection == 3) {
            newY = y - Integer.parseInt(token.substring(1, token.length()));
            for (int i = y - 1; i >= newY; i--) {
              Point newPoint = new Point(x, i);
              checkForIntersection(locations, newPoint);
              toAdd.add(newPoint);
            }
            y -= Integer.parseInt(token.substring(1, token.length()));
          }
          if (currentDirection == 4) {
            newX = x - Integer.parseInt(token.substring(1, token.length()));
            for (int i = x - 1; i >= newX; i--) {
              Point newPoint = new Point(i, y);
              checkForIntersection(locations, newPoint);
              toAdd.add(newPoint);
            }
            x -= Integer.parseInt(token.substring(1, token.length()));
          }
        }
        locations.addAll(toAdd);
      }
      System.out.println(Math.abs(x) + Math.abs(y));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void checkForIntersection(ArrayList<Point> locations, Point newPoint) {
    for (Point p : locations) {
      // System.out.println("Comparing to: " + p.getX() + " " + p.getY());
      if (p.getX() == newPoint.getX() && p.getY() == newPoint.getY()) {
        System.out.println("Found: " + (Math.abs(p.getX()) + Math.abs(p.getY())));
        System.exit(0);
      }
    }

  }
}
