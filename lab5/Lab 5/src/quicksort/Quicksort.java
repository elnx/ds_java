package quicksort;
import java.util.*;
public class Quicksort {
	static int m = 5;
	private Quicksort() { }
    // Your code here
    public static int[] sort(int[] unsorted) {
    	int len = unsorted.length;
    	if (len <= m)  {
    		insertionSort(unsorted);
    	} else {
    		quickSort(unsorted, 0, len-1);	
    	}
    	return unsorted;
    }
    public static void insertionSort(int[] a) {
    	int lo = 0;
    	int hi = a.length - 1;
    	int i = hi;
    	for (; i > lo; --i) {
    		if (a[i] < a[i-1]) {
    			int tmp = a[i];
    			a[i] = a[i-1];
    			a[i-1] = tmp;
    		}
    	}
    	for (i = lo + 2; i <= hi; ++i) {
    		int j, tmp;
    		for (j = i, tmp = a[i]; tmp < a[j-1]; --j)
    			a[j] = a[j-1];
    		a[j] = tmp;
    	}
    	return;
    }
    public static void quickSort(int[] a, int lo, int hi) {
    	if (hi <= lo) return;
    	int i = partition(a, lo, hi);
    	quickSort(a, lo, i-1);
    	quickSort(a, i+1, hi);
    }
    public static int partition(int[] a, int lo, int hi) {
    	int pivot = a[lo];
    	for (;;) {
    		if (lo >= hi) break; 
	    	while ((lo < hi) && (pivot <= a[hi])) --hi;
	    	a[lo] = a[hi];
	    	while ((lo < hi) && (pivot >= a[lo])) ++lo;
	    	a[hi] = a[lo];
    	}
    	a[lo] = pivot;
    	return lo;
    }
    
    public static int[] getrandomarray(int log){
        int[] result = new int[log];
        for (int i = 0; i < log; i++) {
                result[i] = i;
        }
        for (int i = 0; i < log; i++) {
                int random = (int) (log * Math.random());
                int temp = result[i];
                result[i] = result[random];
                result[random] = temp;
        }
        return result;
    }
    // Your code here
    public static void main(String[] args) {
    	int[] unsorted = null;
    	for (int i = 1; i <= 30; ++i) {
    		unsorted = getrandomarray(100000);
    	    long startMili = System.currentTimeMillis();
    		sort(unsorted);
    		long endMili = System.currentTimeMillis();
    		System.out.printf("m = %d %d\n", i, endMili-startMili);
    	}
    	return;
    }
}
