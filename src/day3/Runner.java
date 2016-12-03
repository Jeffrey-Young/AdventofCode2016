package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {
  
  public static void main(String[] args){
    try {
      BufferedReader reader = new BufferedReader(new FileReader("input/day3input1.txt"));
      int validTriangle = 0;
      while(reader.ready()){
        Scanner s1 = new Scanner(reader.readLine());
        Scanner s2 = new Scanner(reader.readLine());
        Scanner s3 = new Scanner(reader.readLine());
//        System.out.print(s.nextInt() + " ");
//        System.out.print(s.nextInt() + " ");
//        System.out.println(s.nextInt());
        int num11 = s1.nextInt();
        int num21 = s1.nextInt();
        int num31 = s1.nextInt();
        
        int num12 = s2.nextInt();
        int num22 = s2.nextInt();
        int num32 = s2.nextInt();
        
        int num13 = s3.nextInt();
        int num23 = s3.nextInt();
        int num33 = s3.nextInt();
        if (num11 + num12 > num13 && num11 + num13 > num12 && num12 + num13 > num11){
          validTriangle++;
        }
        if (num21 + num22 > num23 && num21 + num23 > num22 && num22 + num23 > num21){
          validTriangle++;
        }
        if (num31 + num32 > num33 && num31 + num33 > num32 && num32 + num33 > num31){
          validTriangle++;
        }
      }
      System.out.println(validTriangle);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
  

}
