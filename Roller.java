import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Roller {

	private Random rand = new Random();
	
	public int stat() {
		int a = rand.nextInt(20) + 1 + 7;
		int b = rand.nextInt(20) + 1 + 7;
		ArrayList<Integer> all = new ArrayList<Integer>();
		all.add(a);all.add(b);
		int sum = 0; 
		sum = Collections.max(all);
		return sum;
	}
	
	public int stat(int toRoll, int modifier, String option) {
		int[] values = new int[toRoll];
		Lambda a;
		for (int i = 0; i < toRoll; i++)
			values[i] = rand.nextInt(20) + 1 + modifier;
		if (option.equals("max"))
			a = (vals) -> max(vals);
		else if (option.equals("min")) 
			a = (vals) -> min(vals);
		else
			a = null;
		return a.operation(values);
	}
	
	public static int max(int ... values) {
		int max = Integer.MIN_VALUE;
		for (Integer val : values)
			if (max < val) max = val;
		return max;
	}
	public static int min(int ... values) {
		int min = Integer.MAX_VALUE;
		for (Integer val : values)
			if (min > val) min = val;
		return min;
	}
}
