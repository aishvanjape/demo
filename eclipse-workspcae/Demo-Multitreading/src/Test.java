import java.util.Scanner;

public class Test extends Thread{
      private int i;
      public void run(){
            i++;
      }

      public static void main(String[] args){
            Test a = new Test();
            a.run();
            System.out.print(a.i);
            a.start();
            System.out.print(a.i);
            
            
      }
}