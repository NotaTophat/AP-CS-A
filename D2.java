import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D2{
  public static void main(String[] args){
    String[] inputs = new String[1000];
    int size = 0;

    try {
        File file = new File("mini.txt");
        Scanner input = new Scanner(file);

        while(input.hasNextLine()){
          String next = input.nextLine();
          String[] lineInputs = next.split(",");
          
          for (int i = 0; i < lineInputs.length; i++){
            inputs[size] = lineInputs[i];
            size++;
          }
        }

        input.close();
    } catch (FileNotFoundException ex) {System.out.println("File not found");}

    long count = 0L;
    for (int i = 0; i < size; i++){
      String entry = inputs[i];
      int dashPos = entry.indexOf("-");

      long h1 = Long.parseLong(entry.substring(0,dashPos));
      long h2 = Long.parseLong(entry.substring(dashPos + 1));

      for (long ii = h1; ii <= h2; ii++){
        int length = (int)(Math.log10(ii));
        boolean success2 = false;

        for (int base = 1; base <= length; base++){
          if (length % base != 0){continue;}

          int shift = (int)(Math.pow(10, base));

          long sequence = ii % shift;
          boolean success = true;
          
          for (int shifty = base; shifty <= length; shifty += shift){
            long compareTo = (ii / ((long) Math.pow(shift, shifty))) % shift;
            System.out.println(compareTo + ", " + sequence);
            if (compareTo != sequence){success = false; break;} 
          }

          if (success){success2 = true; break;}
        }
        
        if (success2){System.out.println(ii); count += ii;}
      }
    }

    System.out.println("\n" + count);
  }
}
