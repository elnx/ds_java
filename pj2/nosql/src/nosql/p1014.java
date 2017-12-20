package nosql;
import java.util.*;

public class p1014 {
	static TreeMap<String, ArrayList<String>> suffix = new TreeMap<String, ArrayList<String>>();
	public static void buildSuffix(String key) {
		String suf = null;
		ArrayList<String> keys = null;
		if (suffix.containsKey(key)) return;
		
		for (int i = 0; i < key.length(); ++i) {
			suf = key.substring(i);
			if (!suffix.containsKey(suf)) {
				keys = new ArrayList<String>();
				keys.add(key);
				suffix.put(suf, keys);
			} else {
				suffix.get(suf).add(key);
			}
		}
	}
	public static void main(String[] rgs){
		Scanner in = new Scanner(System.in);
		TreeMap<String, Long> map = new TreeMap<String, Long>();  
		
		int n = in.nextInt();
		in.nextLine();
		String cmd = null;
		String key = null;
		long value = 0;
		String line = null; 
		int i = 0;
		int putcount = 0;
		while (i < n) {
			line = in.nextLine();
			String[] tmp = line.split(" ");
			cmd = tmp[0];
			key = tmp[1];
			switch (cmd) {
			case "PUT":
				buildSuffix(key);
				value = Long.parseLong(tmp[2]);
				map.put(key, value);
				break;
			case "ADD":
				value = Long.parseLong(tmp[2]);
				map.put(key, value +map.get(key));
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
						map.put(k, map.get(k) + value);
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
			case "ADDCONTAIN":
				value = Long.parseLong(tmp[2]);
				HashSet<String> keys = new HashSet<String>();
				for (String suf : suffix.tailMap(key).keySet()) { // suffix 
					if (suf.startsWith(key)) {
						for (String k : suffix.get(suf)) { // key list
							keys.add(k); 
						}
					} else
						break;
				}
				for (String k : keys) {
					//System.out.printf("%s : %d", k, map.get(k));
					map.put(k, map.get(k) + value);
					//System.out.printf(" -> %d\n", map.get(k));
				}
				break;
			
			case "QUERYCONTAIN":
				value = 0;
				keys = new HashSet<String>();
				for (String suf : suffix.tailMap(key).keySet()) { // suffix 
					if (suf.startsWith(key)) {
						for (String k : suffix.get(suf)) { // key list
							keys.add(k); 
						}
					} else
						break;
				}
				for (String k : keys) {
					value += map.get(k);
				}
				System.out.println(value);
				break;
				
			case "DELCONTAIN":
				keys = new HashSet<String>();
				for (String suf : suffix.tailMap(key).keySet()) { // suffix 
					if (suf.startsWith(key)) {
						for (String k : suffix.get(suf)) { // key list
							keys.add(k); 
						}
					} else
						break;
				}
				for (String k : keys) {
					map.put(k, (long)0);
				}
				break;
			}
			++i;
		}
	}
}