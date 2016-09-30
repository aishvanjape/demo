class L {
  void printS1() {System.out.print("C.printS1 ");}
  static void printS2(int a) {System.out.print("C.printS2 ");}
}
class D extends L {
  void printS1(){System.out.print("D.printS1 ");}
  static void  printS2() {System.out.print("D.printS2 ");}
  public static void main (String args[]) {
    //L c = new D(); c.printS1(); c.printS2();
}}
