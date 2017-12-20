package nosql;
import java.util.*;

public class p1011 {
	public static void main(String[] rgs){
		Scanner in = new Scanner(System.in);
		TreeMap<String , Long> map = new TreeMap<String, Long>();  
		int n = in.nextInt();
		in.nextLine();
		String cmd = null;
		String key = null;

		long value = 0;
		String line = null; 
		int i = 0;
		while (i < n) {
			line = in.nextLine();
			String[] tmp = line.split("\\s+");
			cmd = tmp[0];
			key = tmp[1];
			switch (cmd) {
			case "PUT":
				value = Long.parseLong(tmp[2]);
				map.put(key, value);
				break;
			case "ADD":
				value = Long.parseLong(tmp[2]);
				long old = map.get(key);
				map.put(key, value + old);
				break;
			case "QUERY":
				System.out.println(map.get(key));
				break;
			case "DEL":
				map.put(key, (long) 0);
				break;
			case "ADDBEGINWITH":
				value = Long.parseLong(tmp[2]);
				for (String k :map.tailMap(key).keySet()) {
					if (k.startsWith(key)) {
						old = map.get(k);
						map.put(k, old + value);
					} else {
						break;
					}
				}
				break;
			case "QUERYBEGINWITH":
				value = 0;
				for (String k :map.tailMap(key).keySet()) {
					if (k.startsWith(key)) {
						value += map.get(k);
					} else {
						break;
					}
				}
				System.out.println(value);
				break;
			case "DELBEGINWITH":
				for (String k :map.tailMap(key).keySet()) {
					if (k.startsWith(key)) {
						map.put(k, (long)0);
					} else {
						break;
					}
				}
				break;
			}
			++i;
		}
	}
	
}