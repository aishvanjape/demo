import com.simulationdemo.Animal;
import com.simulationdemo.Cat;
import com.simulationdemo.Feline;
import com.simulationdemo.Lion;
import com.simulationdemo.Cat;
public class Entry {
	public static void main(String[] args) {
		B.m1("main");
		Cat c = new Cat("Feline","");
		c.roam();
		
		Lion l = new Lion("L","");
		l.roam();
		
		Feline f = new Feline("A","");
		f.roam();
		
		System.out.println(c.getSize());
		
		Animal a;
		
//		IMPLICIT UP-CASTING
		a = (Animal)c;
		/*a= new Animal("","");
		c = (Cat)a;
		c.roam();
		*/
		a.roam();
		a = (Animal)l;
		a.roam();
		a=(Animal)f;
		a.roam();
		
		//System.out.println(a.getSize());
	}
}
