import java.util.HashMap;
import java.util.HashSet;

public class Entry5 {

	public static void main(String[] args) {
		HashSet<Integer> values = new HashSet<>();
		values.add(1);
		values.add(2);
		for(int v:values)
		{
			System.out.println(v);
		}
		
		
		HashMap<Integer, String> entries = new HashMap<>();
		
		entries.put(1, "123");
		entries.put(null, "Key nf");
		System.out.println(entries.getOrDefault(null, "def"));
		
	}
}
