import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Advent1{
  public static void main(String[] args){
    int inputSize = 0;
    String[] inputs = new String[10000];

    try {
      File file = new File("input1.txt");
      Scanner input = new Scanner(file);

      while(input.hasNextLine()){
        String next = input.nextLine();
        //System.out.println(next  + ", " + inputSize);

        inputs[inputSize] = next;
        inputSize++;
      }

      input.close();
    } catch (FileNotFoundException ex) {System.out.println("File not found");}

    int returnVal = 0;
    int count =50;
    for (int i = 0; i < inputSize; i++){
      String v = inputs[i]; //
      System.out.println(v + ", " + count);
      int value = Integer.parseInt(v.substring(1));
      for (int e = 0; e < value; e++){
        count += (v.charAt(0) == 'L') ? -1 : 1;

        if (count % 100 == 0){returnVal++;}
      }
    }

    System.out.println(returnVal + ", " + ((count % 100) + 100) % 100);
  }
}