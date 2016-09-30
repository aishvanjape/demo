
class A {

	void m1() {System.out.print("A.m1");}
}
class B extends A{
	void m1() {System.out.print("B.m1");}
	  static void m1(String s) {System.out.print(s+",");}

}
class C {
	  public static void main (String[] args) {B.m1("main"); new B().m1();}
}