package bloomfilter;

import java.util.BitSet;

public class BloomFilter {
	
	//determine the size of bit array
	private int size = 1<<24;
	//determine the number of hash function (different seeds)
	private int[] seeds = {131, 1313, 13131, 131313, 1313131, 13131313, 131313131, 1313131313, 31, 313, 3131};
	BitSet bits = new BitSet(size);

	public BloomFilter() {}
	
	//add an element to Bloom Filter
	public void add(String str) {
		for (int i = 0; i < seeds.length; ++i) {
			int seed = seeds[i];
			int hash = hash(seed, str);
			bits.set(hash, true);
		}
	}
	
	//query whether Bloom Filter contains the element
	public boolean query(String str) {
		for (int i = 0; i < seeds.length; ++i) {
			int seed = seeds[i];
			int hash = hash(seed, str);
			if (!bits.get(hash)) {
				return false;
			}
		}
		return true;
	}
	
	//Your hash function
	private int hash(int seed, String str) {
    	int i, sum = 0;
    	for (i = 0; i < str.length(); i++) 
    		sum = sum*seed + str.charAt(i);
        return (sum&0x7fffffff)%size; 
	}
	
}
