import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class C {

	void m1() {System.out.print("A.m1");}
}
class B extends C{
	void m1() {System.out.print("B.m1");}
	  static void m1(String s) {System.out.print(s+",");}

}
class A {
	static int value = 0;
	public static void sameValue() throws IOException
	{
		FileOutputStream fOut = new FileOutputStream("\\abc.txt");
		fOut.write((byte)value);
	}
	public static void main(String[] args) {
		B.m1("main");
	}
}