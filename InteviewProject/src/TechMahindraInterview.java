import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TechMahindraInterview {

	public static void main(String[] args) {
		
		int k = 2;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(21);
		list.add(21);
		list.add(31);
		list.add(31);
		
		Iterator<Integer> itr = list.iterator();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		while(itr.hasNext()) {
			int num = itr.next();
			if(map.containsKey(num)) {
				int count = map.get(num);
				map.put(num, count+1);
			}else {
				map.put(num, 1);
			}
		}
		
		for(Integer val: map.keySet()) {
			if(map.get(val) == k) {
				System.out.println(val);
				break;
			}
		}
	}
	
}
