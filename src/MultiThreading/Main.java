package MultiThreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] arg) {
		
		//Q4 Dépendance entre les taches
		/*
		Task tc = new Task("C");
		Thread thc = new Thread(tc, "TC");
		
		Task tb = new Task("B", new ArrayList<Thread>(Arrays.asList(thc)));
		Thread thb = new Thread(tb, "TB");
		
		Task ta = new Task("A", new ArrayList<Thread>(Arrays.asList(thb)));
		Thread tha = new Thread(ta, "TA");
		
		tha.start();
		thb.start();
		thc.start();
		*/
		
		//Q5 InterDépendance bouclée
		/*
		Task tc = new Task("C");
		Thread thc = new Thread(tc, "TC");
		
		Task tb = new Task("B", new ArrayList<Thread>(Arrays.asList(thc)));
		Thread thb = new Thread(tb, "TB");
		
		Task ta = new Task("A", new ArrayList<Thread>(Arrays.asList(thb)));
		Thread tha = new Thread(ta, "TA");
		
		Task td = new Task("D", new ArrayList<Thread>(Arrays.asList(tha)));
		Thread thd = new Thread(td, "TD");
		
		tc.setPredecesseurs(thd);
		
		tha.start();
		thb.start();
		thc.start();
		thd.start();
		*/
		
		//Cas Générique
		int n = Integer.parseInt(arg[0]);
		List<Thread> threads = new ArrayList<Thread>();
		if(n>0) {
			threads.add(new Thread(new Task(Integer.toString(n)), "T" + Integer.toString(n)));
			
			for(int i=n-1; i>0; i-- ) {
				threads.add(
						new Thread(
								new Task(
										Integer.toString(i),
										new ArrayList<Thread>(Arrays.asList(threads.get(n-(i+1))))
								)
								, "T" + Integer.toString(i)
						)
				);
			}
			Collections.reverse(threads);
			for (Thread thread : threads) {
				thread.start();
			}
		}
				
	}
	
	
}
