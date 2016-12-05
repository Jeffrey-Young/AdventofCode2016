package day5;

import java.security.MessageDigest;

public class Runner {

  public static void main(String[] args) {

    byte[] bytesOfMessage;
    char[] password = new char[8];
    int foundCount = 0;
    try {
      int counter = 0;
      bytesOfMessage = ("ugkcyxxp" + counter).getBytes("UTF-8");
      MessageDigest md = MessageDigest.getInstance("MD5");
      while (true) {
        byte[] thedigest = md.digest(bytesOfMessage);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < thedigest.length; i++) {
          sb.append(Integer.toString((thedigest[i] & 0xff) + 0x100, 16).substring(1));
        }
        if (sb.toString().substring(0, 5).equals("00000")) {

          int position = Character.getNumericValue((sb.toString().charAt(5)));
          if (position >= password.length){
            counter++;
            bytesOfMessage = ("ugkcyxxp" + counter).getBytes("UTF-8");
            continue;
          }
          if (password[position] == '\u0000'){
            password[position] = sb.toString().charAt(6);
            foundCount++;
            System.out.println("found one");
          }
        }
        if (foundCount >= 8){
          break;
        }
        counter++;
        bytesOfMessage = ("ugkcyxxp" + counter).getBytes("UTF-8");
      }
      for (char i : password){
        System.out.print(i);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
