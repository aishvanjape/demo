import java.util.Iterator;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

//import com.simulationdemo.Person;

public class Entry2 {

	public static void main(String[] args) {
		Person p1 = new Person("abc",1);
		
		TreeSet t1 = new TreeSet();
		t1.add(p1);
		Iterator itr= t1.iterator();
		
		while(itr.hasNext())
		{
			Person e = (Person)itr.next();
			System.out.println(e);
		}
		
		
	}
}
