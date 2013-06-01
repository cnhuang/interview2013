package multithread;

import org.testng.annotations.Test;

import util.Question;

public class MultiThread extends Question {

	@Override
	public String getQuestion() {
		return "MultiThread";
	}

	@Test
	public static void run() throws InterruptedException {
		int reader = 10;
		int writter = 10;
		Queue q = new Queue(20);

		Thread[] rT = new Thread[reader];
		for (int i = 0; i < reader; i++) {
			rT[i] = new Thread(new Reader(q, i));
			rT[i].start();
		}

		Thread[] wT = new Thread[reader];
		for (int i = 0; i < writter; i++) {
			wT[i] = new Thread(new Writter(q, i));
			wT[i] .start();
		}
		
		for (int i = 0; i < reader; i++) 
			rT[i].join();
			
		for (int i = 0; i < writter; i++) 
			wT[i].join();
	}

	public static class Queue {
		int[] data;
		int index = 0;

		public Queue(int size) {
			data = new int[size];
		}

		synchronized int Read() {
			while (index == 0) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			int d = data[index--];
			this.notifyAll();
			return d;
		}

		synchronized void Write(int i) {
			while (index == data.length) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			data[index++] = i;
			this.notifyAll();
		}
	}

	public static class Reader implements Runnable {

		Queue _queue;
		int _id;

		public Reader(Queue queue, int id) {
			_queue = queue;
			_id = id;
		}

		protected void Read() {
			System.out.println("Reader " + _id + " Read " + _queue.Read());
		}

		public void run() {
			while (true) {
				Read();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static class Writter implements Runnable {
		Queue _queue;
		int _id;

		public Writter(Queue queue, int id) {
			_queue = queue;
			_id = id;
		}

		protected void Write() {
			_queue.Write(_id);
			System.out.println("Writter " + _id + " Writter " + _id);
		}

		public void run() {
			while (true) {
				Write();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}