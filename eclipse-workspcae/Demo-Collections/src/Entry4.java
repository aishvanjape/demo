import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Entry4 {

	public static void main(String[] args) {
		Map<Long, String> entries = new TreeMap<>();
		entries.put(1234L, "ABC");
		entries.put(5678L, "value");
		
		System.out.println(entries.get(12345L));
		Long l = new Long(1234L);
		System.out.println(entries.get(l));
		Set<Map.Entry<Long,String>> s = entries.entrySet();
		
		for (Map.Entry<Long,String> s1 : s)
		{
			System.out.println(s1);
		}
	}
	
	
	
	
	
}
