package MultiThreading;

import java.util.ArrayList;
import java.util.Arrays;

public class Task implements Runnable{
	
	private String label;
	private ArrayList<Thread> predecesseurs;
	
	public Task(String label, ArrayList<Thread> predecesseurs) {
		this.label =label;
		this.predecesseurs = predecesseurs;
	}

	public Task(String label) {
		this(label, new ArrayList<Thread>());
	}
	
	public Task() {
		this("Z", new ArrayList<Thread>());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub)
		for (Thread thread : predecesseurs) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Tache " + label + " terminée");
		
	}
	
	public void setPredecesseurs(Thread t) {
		predecesseurs = new ArrayList<Thread>(Arrays.asList(t));
	}
}
