//import java.util.*;

interface Counter {
	long count(double[] riceArray);
}

public class FatherCounter implements Counter {
	@Override
    public long count(double[] riceArray) {
       long total = 0;
       for (double i : riceArray){ 
         if (i == 1)
           total += 1;
         if (total >= 1e8) 
           break;
       }
       return total;
	}
	public static void main(String[] args) {
		long length = 120000000;
		double[] riceArray = new double[(int)length];
		for(long i = 0; i < length; i++) {
			riceArray[(int)i] = 1;
		}
		
		Counter counter = new FatherCounter();
		long startTime = System.currentTimeMillis();
		long value = counter.count(riceArray);
		long endTime = System.currentTimeMillis();
		System.out.println("消耗时间(毫秒)：" + (endTime - startTime));
	}
}