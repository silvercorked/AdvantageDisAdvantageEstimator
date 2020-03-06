import java.math.BigDecimal;
import java.util.LinkedList;

public class Runner {

	public static void main(String[] args) {
		int rollUpTo = 30;
		int iterationsMax = 10000000;
		LinkedList<BigDecimal> results = new LinkedList<BigDecimal>();
		for (int dataset = 1; dataset <= rollUpTo; dataset++) {
			BigDecimal statsAvg = new BigDecimal(0);
			for(int i = 1; i <= iterationsMax; i++) {
				Roller td = new Roller();
				int current = td.stat(dataset, 0, "max");
				statsAvg = statsAvg.add(new BigDecimal(current));
				try {
					if (i % 50000000 == 0) {
						System.out.println("Average stats Value = " + statsAvg.divide(new BigDecimal(i)).toString());
						System.out.println("Current Stat Sum = " + statsAvg);
						System.out.println("Current Iteration = " + i);
					}
					else if (i % 10000000 == 0) {
						System.out.println("Average stats Value Approximate = " + (Double.parseDouble(statsAvg.toString()) / i));
						System.out.println("Current Stat Sum = " + statsAvg);
						System.out.println("Current Iteration = " + i);
					}
					
				} catch (ArithmeticException e) {
					System.out.println(e.getMessage());
				}
			}
			results.add(statsAvg);
		}
		for (int i = 0; i < results.size(); i++) {
			System.out.println("--------------------------------------------------------");
			System.out.println("Number of dice: " + (i + 1));
			System.out.println("Average Value (Expected Value): " + results.get(i).divide(new BigDecimal(iterationsMax)).toString());
			System.out.println("Total Found: " + results.get(i));
			System.out.println("Iterations: " + iterationsMax);
		}
	}

}
